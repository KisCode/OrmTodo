package net.ormlite.todo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import net.ormlite.todo.R;
import net.ormlite.todo.databinding.FragmentMissionListBinding;
import net.ormlite.todo.ui.adapter.BookListDataBindingAdapter;
import net.ormlite.todo.ui.pojo.Mission;
import net.ormlite.todo.ui.pojo.MissionRecord;
import net.ormlite.todo.viewmodel.MissionViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Description:任务列表
 * Author: keno
 * Date : 2022/4/13 11:14
 **/
public class MissionListFragment extends Fragment {

    private BookListDataBindingAdapter mAdapter;
    private FragmentMissionListBinding binding;
    private MissionViewModel missionViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentMissionListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//        mAdapter = new BookListAdapter(Collections.emptyList());
        mAdapter = new BookListDataBindingAdapter(Collections.emptyList());


        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int pos) {
                Log.i("mission", "click mission at " + pos);
                Mission mission = (Mission) adapter.getItem(pos);
                if (mission == null) return;
                Log.i("mission", mission.toString());
                MissionRecord record = new MissionRecord(mission);
                missionViewModel.saveMissionRecord(record);
            }
        });

        binding.recyclerview.setAdapter(mAdapter);
        //setEmptyView方法需要在setAdapter方法之后才能生效
        mAdapter.setEmptyView(R.layout.layout_empty);

        NavController navController = Navigation.findNavController(view);
        binding.fabAdd.setOnClickListener(view1 -> navController.navigate(R.id.action_FirstFragment_to_SecondFragment));

        missionViewModel = new ViewModelProvider(this
                , new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(MissionViewModel.class);
        missionViewModel.getAllMission().observe(getActivity(), new Observer<List<Mission>>() {
            @Override
            public void onChanged(List<Mission> missions) {
                mAdapter.setNewInstance(missions);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}