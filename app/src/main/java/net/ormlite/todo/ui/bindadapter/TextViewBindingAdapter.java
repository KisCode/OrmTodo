package net.ormlite.todo.ui.bindadapter;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import net.ormlite.todo.constants.MissionStatus;
import net.ormlite.todo.util.DateUtil;

public class TextViewBindingAdapter {

    @BindingAdapter("dateTime")
    public static void bindDateTime(TextView textView, long dateTime) {
        String dateTimeStr = DateUtil.formatDateStr(dateTime, DateUtil.FORMAT_STR_DATE_yyyy_MM_dd_HHmmss);
        textView.setText(dateTimeStr);
    }

    @BindingAdapter("missionStatus")
    public static void bindMissionStatus(TextView textView, MissionStatus status) {
        String statusStr = "";
        switch (status) {
            case NEW:
                statusStr = "New";
                break;
            case PROGRESS:
                statusStr = "Progress";
                break;
            case COMPLETED:
                statusStr = "Completed";
                break;
        }
        textView.setText(statusStr);
    }
} 