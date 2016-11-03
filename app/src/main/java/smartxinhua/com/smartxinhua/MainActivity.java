package smartxinhua.com.smartxinhua;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import smartxinhua.com.smartxinhua.fragment.ContentFragment;
import smartxinhua.com.smartxinhua.fragment.LeftMenuFragment;

public class MainActivity extends SlidingFragmentActivity {
    private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
    private static final String TAG_CONTENT = "TAG_CONTENT";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题,这个恶搞方法必须在setcontentview之前调用
        setContentView(R.layout.activity_main);
        //Utils.something();测试库
        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();//获取侧边栏对象
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏触摸
        slidingMenu.setBehindOffset(400);//屏幕预留宽度是200像素
        //如果这里报错了,可能是v4包冲突,删掉其中一个就可以了
        initFragment();
    }
    /**
     * 初始化fragment对象
     */

    private void initFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_left_menu,new LeftMenuFragment(),TAG_LEFT_MENU);//用fragment替换帧布局参数1是帧布局容器的id,参数2是要替换的fragment,参数3是标记,为了以后方便查找
        transaction.replace(R.id.fl_main,new ContentFragment(),TAG_CONTENT);

        transaction.commit();//提交事务
       // Fragment fragment = fm.findFragmentByTag(TAG_CONTENT);//根据标记找到对应的fragment
    }
    // 获取侧边栏fragment对象
   /* public LeftMenuFragment getLeftMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        LeftMenuFragment fragment = (LeftMenuFragment) fm
                .findFragmentByTag(TAG_LEFT_MENU);// 根据标记找到对应的fragment
        return fragment;
    }

    // 获取主页fragment对象
    public ContentFragment getContentFragment() {
        FragmentManager fm = getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) fm
                .findFragmentByTag(TAG_CONTENT);// 根据标记找到对应的fragment
        return fragment;
    }*/
}
