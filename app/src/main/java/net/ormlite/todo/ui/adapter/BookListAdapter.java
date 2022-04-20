package net.ormlite.todo.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import net.ormlite.todo.R;
import net.ormlite.todo.ui.pojo.Mission;

import java.util.List;

public class BookListAdapter extends BaseQuickAdapter<Mission, BaseViewHolder> {
    public BookListAdapter(List<Mission> missionList) {
        super(R.layout.item_mission_list, missionList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Mission mission) {
        baseViewHolder.setText(R.id.tv_mission_name, mission.getName());
        baseViewHolder.setText(R.id.tv_mission_createTime, String.valueOf(mission.getCreateTime()));
        baseViewHolder.setText(R.id.tv_mission_status, String.valueOf(mission.getStatus()));
    }
}