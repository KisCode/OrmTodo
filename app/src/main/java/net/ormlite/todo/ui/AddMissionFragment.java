package net.ormlite.todo.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
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

import net.ormlite.todo.databinding.FragmentMissionAddBinding;
import net.ormlite.todo.ui.pojo.Mission;
import net.ormlite.todo.ui.pojo.MissionRecord;
import net.ormlite.todo.viewmodel.MissionViewModel;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;


public class AddMissionFragment extends Fragment {

    private FragmentMissionAddBinding binding;
    private MissionViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentMissionAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        //初始化数据绑定
        Mission mission = new Mission();
        binding.setMission(mission);
        binding.setLifecycleOwner(this);

        binding.btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mission mission = binding.getMission();
                viewModel.saveMission(mission);
            }
        });
        String str ="\uD83C\uDF43\uD83D\uDC0B\uD83D\uDC1F\uD83C\uDFB9";
        try {
            Typeface typeFace = Typeface.createFromAsset(getResources().getAssets(),"AndroidEmoji.ttf");
            binding.tvEmoji.setTypeface(typeFace);
            binding.tvEmoji.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewModel = new ViewModelProvider(this
                , new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(MissionViewModel.class);
        viewModel.getSaveStatusLiveData()
                .observe(getActivity()
                        , new Observer<Boolean>() {
                            @Override
                            public void onChanged(Boolean isSuccess) {
                                Log.i("saveMission", "保存结果 " + isSuccess);
                                navController.navigateUp();
                            }
                        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}