package life.wy.a.recorder.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by wangying on 2016/10/18.
 */

public class AppUtils {

    /**
     * 安全打开Activity
     *
     * @param context
     * @param intent
     */
    public static void startActivitySafe(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
