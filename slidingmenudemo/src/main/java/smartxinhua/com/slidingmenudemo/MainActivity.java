package smartxinhua.com.slidingmenudemo;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 使用SlidingMenu
 * 1,引入库项目,在project structure 中点击dependence中添加
 * 2,继承SlidingFragmentActivity.
 * 3,oncreate改成public
 * 4,调用相关API
 */
public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置侧边栏
        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();
        //设置右侧边栏
        slidingMenu.setSecondaryMenu(R.layout.right_menu);
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);//设置左右两边都可以滑动
        //设置全屏触摸方法
        slidingMenu.getTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置侧边栏宽度
        slidingMenu.setBehindOffset(200);//设置的是屏幕预留的宽度
    }
}
