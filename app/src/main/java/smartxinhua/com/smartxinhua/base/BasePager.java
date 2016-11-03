package smartxinhua.com.smartxinhua.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import smartxinhua.com.smartxinhua.R;

/**
 * 就是一个类
 * 五个标签类的基类
 * Created by Zoe on 2016/11/3.
 */
public class BasePager {
    public Activity mActivity;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;//这是一个空的帧布局对象,要动态添加布局
    private final View mRootView;

    public BasePager (Activity activity){
        mActivity = activity;
        mRootView = initView();//当前页面的布局对象
    }
    //初始化布局
    public View initView(){
       View view = View.inflate(mActivity, R.layout.base_pager,null);
        tvTitle = (TextView)view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton)view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout)view.findViewById(R.id.fl_content);
        return view;
    }
    //初始化数据
    public void initData(){

    }
}
