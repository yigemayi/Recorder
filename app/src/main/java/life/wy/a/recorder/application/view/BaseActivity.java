package life.wy.a.recorder.application.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 基础Activity
 * Created by wangying on 2016/10/18.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }
}
