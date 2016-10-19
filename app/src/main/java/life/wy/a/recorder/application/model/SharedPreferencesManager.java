package life.wy.a.recorder.application.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreference管理器
 * Created by wangying on 2016/10/17.
 */

public class SharedPreferencesManager {

    private Context mContext;

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesManager(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences("recorder", Context.MODE_PRIVATE);
    }

    /**
     * 存储值
     *
     * @param key
     * @param values
     */
    public void commitBoolean(String key, boolean values) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, values);
        editor.commit();
    }

    /**
     * 获取Boolean值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * @param key
     * @param values
     */
    public void commitLong(String key, long values) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, values);
        editor.commit();
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public long getLong(String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    public void commitString(String key, String values) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, values);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

}
