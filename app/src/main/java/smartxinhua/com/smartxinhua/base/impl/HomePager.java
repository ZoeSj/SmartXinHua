package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.view.View;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;

/**
 *首页
 * 也叫做新华BBC,这里面主要包裹的内容是一个webview网页.
 * Created by Zoe on 2016/11/3.
 */
public class HomePager extends BasePager {
    public HomePager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.homepager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象
    }
}
