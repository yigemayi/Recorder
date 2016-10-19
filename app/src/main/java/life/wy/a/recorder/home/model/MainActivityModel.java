package life.wy.a.recorder.home.model;

import android.app.AlarmManager;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import life.wy.a.recorder.application.GlobalSingleInstanceManager;
import life.wy.a.recorder.application.model.SharedPreferencesManager;
import life.wy.a.recorder.application.model.constant.IPreferenerIds;
import life.wy.a.recorder.function.exchange.ExchangeUtil;
import life.wy.a.recorder.home.presenter.IMainActivityPresenter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangying on 2016/10/18.
 */

public class MainActivityModel implements IMainActivityModel {

    private Context mContext;

    private IMainActivityPresenter mMainActivityPresenter;

    private SharedPreferencesManager mSharedPreferencesManager;

    public MainActivityModel(Context context, IMainActivityPresenter presenter) {

        mContext = context;
        mMainActivityPresenter = presenter;
        mSharedPreferencesManager = GlobalSingleInstanceManager.getInstance().getSharedPreferencesManager();
        updateExchangeData();
    }

    @Override
    public String getExchangeRateText() {
        return mSharedPreferencesManager.getString(IPreferenerIds.KEY_EXCHANGE_RATE, "Demo Test");
    }

    // 更新汇率信息
    private void updateExchangeData() {
        long lastUpdateTime = mSharedPreferencesManager.getLong(IPreferenerIds.KEY_EXCHANGE_UPDATE_TIME, 0);
        if (lastUpdateTime == 0) {
            // 没有成功获取过汇率信息,立即获取
            getExchangeByNet();

        } else if (System.currentTimeMillis() - lastUpdateTime >= 8 * AlarmManager.INTERVAL_HOUR) {
            // 距离上次成功获取汇率已经过了八小时,再次请求汇率
            getExchangeByNet();
        } else {
            // 直接获取存储的汇率信息,不更新汇率

        }
    }

    private void getExchangeByNet() {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(ExchangeUtil.getRequestUrlString("CNY", "HKD", "json"))
                .build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mSharedPreferencesManager.commitLong(IPreferenerIds.KEY_EXCHANGE_UPDATE_TIME, System.currentTimeMillis());
                mSharedPreferencesManager.commitString(IPreferenerIds.KEY_EXCHANGE_RATE, handlerInputStreamToString(response.body().byteStream()));

            }
        });
    }

    private String handlerInputStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
