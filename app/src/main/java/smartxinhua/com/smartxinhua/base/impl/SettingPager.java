package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.view.View;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;

/**
 * 这个是个人设置中心.
 * Created by Zoe on 2016/11/3.
 */
public class SettingPager extends BasePager {
    public SettingPager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //隐藏菜单按钮
        btnMenu.setVisibility(View.GONE);
        //修改页面标题
        tvTitle.setText("个人设置");
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.settingpager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象
         }
}
