package net.ormlite.todo;

import android.app.Application;

import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.LogBackendType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            //设置日志打印为Android log
            LoggerFactory.setLogBackendFactory(LogBackendType.ANDROID);
            //设置日志打印级别
            Logger.setGlobalLogLevel(Level.TRACE);
        }
    }
}