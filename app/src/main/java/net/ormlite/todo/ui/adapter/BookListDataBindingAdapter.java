package net.ormlite.todo.ui.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;

import net.ormlite.todo.BR;
import net.ormlite.todo.R;
import net.ormlite.todo.ui.pojo.Mission;

import java.util.List;

/***
 * DataBinding适配器使用实例
 */
public class BookListDataBindingAdapter extends BaseQuickAdapter<Mission, BaseDataBindingHolder<ViewDataBinding>> {
    public BookListDataBindingAdapter(List<Mission> missionList) {
        super(R.layout.item_mission_list, missionList);
    }

    @Override
    protected void convert(@NonNull BaseDataBindingHolder<ViewDataBinding> holder, Mission mission) {
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setVariable(BR.mission, mission);
            dataBinding.executePendingBindings();
        }
    }
}
/*

public class BookListDataBindingAdapter extends BaseQuickAdapter<Mission, BaseDataBindingHolder<ItemMissionListBinding>> {
    public BookListDataBindingAdapter(int layoutResId, List<Mission> data) {
        super(layoutResId, data);
    }

    public BookListDataBindingAdapter(List<Mission> missionList) {
        this(R.layout.item_mission_list, missionList);
    }

    @Override
    protected void convert(@NonNull BaseDataBindingHolder<ItemMissionListBinding> holder, Mission mission) {
        ItemMissionListBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setMission(mission);
            dataBinding.executePendingBindings();
        }
    }
}
*/
