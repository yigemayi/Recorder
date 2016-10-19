package life.wy.a.recorder.function.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import life.wy.a.recorder.R;
import life.wy.a.recorder.application.view.BaseActivity;

/**
 * 欢迎页面
 * Created by wangying on 2016/10/17.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.activity_welcome_bg)
    ImageView mBgImageView;

    @BindView(R.id.activity_welcome_enter)
    TextView mEnterTextView;

    @OnClick(R.id.activity_welcome_enter)
    void onClick() {
        if (!isFinishing()) {
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 获取进入的Intent
     *
     * @param context
     * @return
     */
    public static Intent getEntranceIntent(Context context) {
        Intent intent = new Intent(context, WelcomeActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }


}
