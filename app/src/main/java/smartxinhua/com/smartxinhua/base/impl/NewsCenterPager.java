package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.view.View;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;

/**
 * 这是新闻中心页面,也是最难的一个页面.里面内容很多
 * Created by Zoe on 2016/11/3.
 */
public class NewsCenterPager extends BasePager {
    public NewsCenterPager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.newscenterpager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象
    }
}
