package life.wy.a.recorder.home.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import life.wy.a.recorder.R;

/**
 * 主界面的侧边栏Menu
 * Created by wangying on 2016/10/18.
 */

public class DrawerMenu extends LinearLayout {

    @BindView(R.id.drawer_menu_about)
    DrawerMenuItemView mAboutMenuItem;

    public DrawerMenu(Context context) {
        this(context, null);
    }

    public DrawerMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
