package life.wy.a.recorder.home.presenter;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONObject;

import life.wy.a.recorder.application.GlobalSingleInstanceManager;
import life.wy.a.recorder.application.model.SharedPreferencesManager;
import life.wy.a.recorder.application.model.constant.IPreferenerIds;
import life.wy.a.recorder.function.welcome.WelcomeActivity;
import life.wy.a.recorder.home.model.IMainActivityModel;
import life.wy.a.recorder.home.model.MainActivityModel;
import life.wy.a.recorder.home.view.IMainActivityView;
import life.wy.a.recorder.util.AppUtils;

/**
 * 主界面的Presenter层
 * Created by wangying on 2016/10/18.
 */

public class MainActivityPresenter implements IMainActivityPresenter {

    private Context mContext;
    private IMainActivityView mMainActivityView;
    private IMainActivityModel mMainActivityModel;

    public MainActivityPresenter(Context context, IMainActivityView view) {
        mContext = context;
        mMainActivityView = view;
        mMainActivityModel = new MainActivityModel(context, this);
    }


    @Override
    public void onCreate() {
        shouldJumpToWelcomeActivity();
    }

    @Override
    public void onResume() {
        String exchange = mMainActivityModel.getExchangeRateText();
        if (!TextUtils.isEmpty(exchange)) {
            try {
                JSONObject jsonObject = new JSONObject(exchange);
                JSONObject resultJsonObject = (JSONObject) jsonObject.get("result");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(resultJsonObject.get("ratenm"))
                        .append("-->")
                        .append(resultJsonObject.get("rate"))
                        .append("-->").append(resultJsonObject.get("update"));
                mMainActivityView.showExchange(stringBuilder.toString());
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onDestroy() {

    }

    private void shouldJumpToWelcomeActivity() {
        SharedPreferencesManager sharedPreferencesManager = GlobalSingleInstanceManager.getInstance().getSharedPreferencesManager();
        boolean hasEnterWelcome = sharedPreferencesManager.getBoolean(IPreferenerIds.KEY_HAS_ENTER_WELCOME_ACTIVITY, false);
        if (!hasEnterWelcome) {
            AppUtils.startActivitySafe(mContext, WelcomeActivity.getEntranceIntent(mContext));
            sharedPreferencesManager.commitBoolean(IPreferenerIds.KEY_HAS_ENTER_WELCOME_ACTIVITY, true);
        }
    }

}
