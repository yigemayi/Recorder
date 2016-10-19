package life.wy.a.recorder.home;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.SimpleDrawerListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import life.wy.a.recorder.R;
import life.wy.a.recorder.application.view.BaseActivity;
import life.wy.a.recorder.home.drawer.DrawerMenu;
import life.wy.a.recorder.home.presenter.IMainActivityPresenter;
import life.wy.a.recorder.home.presenter.MainActivityPresenter;
import life.wy.a.recorder.home.view.IMainActivityView;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements IMainActivityView {

    private IMainActivityPresenter mMainActivityPresenter;

    @BindView(R.id.activity_main_exchange_show)
    TextView mExchangeShowTextView;

    @BindView(R.id.activity_main_drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.activity_main_drawer_container)
    FrameLayout mDrawer;

    @BindView(R.id.activity_main_title_menu)
    ImageView mMenuView;

    @BindView(R.id.activity_main_drawer_view_stub)
    ViewStub mViewStub;

    private DrawerMenu mDrawerMenu;

    @OnClick(R.id.activity_main_title_menu)
    void onClick() {
        mDrawerLayout.openDrawer(mDrawer);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDrawerLayout.addDrawerListener(new SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });
        mMainActivityPresenter = new MainActivityPresenter(getApplicationContext(), this);
        mMainActivityPresenter.onCreate();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainActivityPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainActivityPresenter.onDestroy();
    }

    @Override
    public void showExchange(String exchangeText) {
        mExchangeShowTextView.setText(exchangeText);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mDrawerMenu == null) {
            mDrawerMenu = (DrawerMenu) mViewStub.inflate();
        }
    }
}
