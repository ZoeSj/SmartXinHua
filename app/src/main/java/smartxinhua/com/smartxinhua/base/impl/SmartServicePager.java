package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.view.View;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;

/**
 * 这个是一个成员介绍页面,主要应用了fragement
 * Created by Zoe on 2016/11/3.
 */
public class SmartServicePager extends BasePager {
    public SmartServicePager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.smartservicepager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象
    }
}
