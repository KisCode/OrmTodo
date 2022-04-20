package net.ormlite.todo.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import net.ormlite.todo.ui.pojo.MissionRecord;
import net.ormlite.todo.ui.pojo.Mission;

import java.sql.SQLException;

public class OrmLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = "OrmLiteHelper";
    private static final String dbName = "toto.db";
    private static final int databaseVersion = 1;

    private static OrmLiteHelper ormLiteHelper;

    public OrmLiteHelper(Context context) {
        super(context, dbName, null, databaseVersion);
    }

    public static synchronized OrmLiteHelper getInstance(Context context) {
        if (ormLiteHelper == null) {
            synchronized (OrmLiteHelper.class) {
                if (ormLiteHelper == null)
                    ormLiteHelper = new OrmLiteHelper(context);
            }
        }
        return ormLiteHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Mission.class);
            TableUtils.createTableIfNotExists(connectionSource, MissionRecord.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //删除原数据库
            TableUtils.clearTable(connectionSource, Mission.class);
            TableUtils.clearTable(connectionSource, MissionRecord.class);
            //重新创建
            TableUtils.createTableIfNotExists(connectionSource, Mission.class);
            TableUtils.createTableIfNotExists(connectionSource, MissionRecord.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}