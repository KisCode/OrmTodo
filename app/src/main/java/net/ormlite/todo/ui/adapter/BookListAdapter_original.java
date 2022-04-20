package net.ormlite.todo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import net.ormlite.todo.BR;
import net.ormlite.todo.R;
import net.ormlite.todo.ui.pojo.Mission;

import java.util.ArrayList;
import java.util.List;

//public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
public class BookListAdapter_original extends RecyclerView.Adapter<BookListAdapter_original.BookViewHolder> {
    private List<Mission> missionList;
    private OnItemClickListener onItemClickListener;

    public BookListAdapter_original() {
        missionList = new ArrayList<>();
    }


    public void setNewData(List<Mission> missionList) {
        if (missionList == null) {
            missionList = new ArrayList<>();
        }
        this.missionList = missionList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookListAdapter_original.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mission_list, parent, false);
        return new BookViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListAdapter_original.BookViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.mission, missionList.get(position));
        holder.getBinding().executePendingBindings();
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return missionList.size();
    }

    public Mission getObject(int position) {
        if (position >= 0 && position < missionList.size()) {
            return missionList.get(position);
        }
        return null;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BookViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}