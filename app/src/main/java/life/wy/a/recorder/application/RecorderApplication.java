package life.wy.a.recorder.application;

import android.app.Application;
import android.content.Context;

/**
 * 自定义进程
 * Created by wangying on 2016/10/17.
 */

public class RecorderApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        GlobalSingleInstanceManager.initInstance(this);

    }
}
