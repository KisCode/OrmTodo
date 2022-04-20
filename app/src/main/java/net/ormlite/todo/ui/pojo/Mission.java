package net.ormlite.todo.ui.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import net.ormlite.todo.constants.MissionStatus;

import java.io.Serializable;
import java.util.Calendar;

@DatabaseTable
public class Mission implements Serializable {

    /***
     * 任务id
     */
    @DatabaseField(generatedId = true)
    private int id;

    /***
     * 任务名称
     */
    @DatabaseField
    private String name;

    /***
     * 任务描述
     */
    @DatabaseField
    private String desc;
    /***
     * 创建时间
     */
    @DatabaseField
    private long createTime;

    /***
     * 任务状态
     */
    @DatabaseField
    private MissionStatus status;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<MissionRecord> missionRecordList;

    public Mission() {
        this("");
    }

    public Mission(String name) {
        this.name = name;
        this.createTime = Calendar.getInstance().getTimeInMillis();
        this.status = MissionStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public void setStatus(MissionStatus status) {
        this.status = status;
    }

    public ForeignCollection<MissionRecord> getRecordList() {
        return missionRecordList;
    }

    public void setRecordList(ForeignCollection<MissionRecord> missionRecordList) {
        this.missionRecordList = missionRecordList;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", missionRecordList=" + missionRecordList +
                '}';
    }
}