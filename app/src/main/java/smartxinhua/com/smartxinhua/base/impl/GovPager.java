package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.view.View;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;

/**
 * 这里面要添加的是一个聊天机器人,主要用于聊天通讯的
 * Created by Zoe on 2016/11/3.
 */
public class GovPager extends BasePager {
    public GovPager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.govpager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象
    }
}
