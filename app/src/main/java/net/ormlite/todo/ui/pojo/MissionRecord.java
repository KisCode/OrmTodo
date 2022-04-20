package net.ormlite.todo.ui.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Calendar;

@DatabaseTable
public class MissionRecord {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private long recordTime;

    @DatabaseField(canBeNull = true, foreign = true, columnName = "mission_id", foreignAutoRefresh = true)
    private Mission mission;

    public MissionRecord() {
    }

    public MissionRecord(Mission mission) {
        this.mission = mission;
        this.recordTime = Calendar.getInstance().getTimeInMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(long recordTime) {
        this.recordTime = recordTime;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}