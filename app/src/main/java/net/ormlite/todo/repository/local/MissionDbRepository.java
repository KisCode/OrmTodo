package net.ormlite.todo.repository.local;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import net.ormlite.todo.repository.OrmLiteHelper;
import net.ormlite.todo.ui.pojo.Mission;
import net.ormlite.todo.ui.pojo.MissionRecord;

import java.sql.SQLException;
import java.util.List;


public class MissionDbRepository {
    public static List<Mission> findAll(Context context) {
        try {
            return OrmLiteHelper.getInstance(context).getDao(Mission.class)
                    .queryForAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /***
     * 查询根据创建时间排序的任务列表
     * @param context 上下文
     * @param ascending 是否升序排序
     * @return 任务列表
     */
    public static List<Mission> findAllOrderByCreateTime(Context context, boolean ascending) {
        try {
            return OrmLiteHelper.getInstance(context).getDao(Mission.class)
                    .queryBuilder()
                    .orderBy("createTime", ascending)
                    .query();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 保存任务
     *
     * @param context
     * @param mission
     * @return
     */
    public static boolean saveOrUpdate(Context context, Mission mission) {
        try {
            Dao.CreateOrUpdateStatus status = OrmLiteHelper.getInstance(context).getDao(Mission.class)
                    .createOrUpdate(mission);
            return status.isCreated() || status.isUpdated();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 保存任务
     *
     * @param context
     * @param missionRecord
     * @return
     */
    public static boolean saveOrUpdateMissionRecord(Context context, MissionRecord missionRecord) {
        try {
            Dao.CreateOrUpdateStatus status = OrmLiteHelper.getInstance(context).getDao(MissionRecord.class)
                    .createOrUpdate(missionRecord);
            return status.isCreated() || status.isUpdated();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
} 