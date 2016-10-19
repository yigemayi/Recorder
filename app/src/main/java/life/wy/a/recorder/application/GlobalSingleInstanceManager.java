package life.wy.a.recorder.application;

import android.content.Context;

import life.wy.a.recorder.application.model.SharedPreferencesManager;

/**
 * 全局单例集中管理类
 * Created by wangying on 2016/10/17.
 */

public class GlobalSingleInstanceManager {

    private Context mContext;

    private SharedPreferencesManager mSharedPreferencesManager;

    private static GlobalSingleInstanceManager sInstance;

    public static void initInstance(Context context) {

        if (sInstance == null) {
            sInstance = new GlobalSingleInstanceManager(context);
        }

    }

    private GlobalSingleInstanceManager(Context context) {
        mContext = context;
        mSharedPreferencesManager = new SharedPreferencesManager(mContext);
    }

    public static GlobalSingleInstanceManager getInstance() {
        return sInstance;
    }


    /**
     * 获取
     *
     * @return
     */
    public SharedPreferencesManager getSharedPreferencesManager() {
        return mSharedPreferencesManager;
    }

}
