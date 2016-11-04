package smartxinhua.com.smartxinhua.base.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;
import smartxinhua.com.smartxinhua.domain.NewsMenu;
import smartxinhua.com.smartxinhua.global.GlobalContants;
import smartxinhua.com.smartxinhua.utils.CacheUtils;

/**
 * 这是新闻中心页面,也是最难的一个页面.里面内容很多
 * Created by Zoe on 2016/11/3.
 */
public class NewsCenterPager extends BasePager {
    public NewsCenterPager(Activity activity) {
        super(activity);
    }
    public void initData(){
        //显示菜单按钮
        btnMenu.setVisibility(View.VISIBLE);
        //先判断有没有缓存,如果有的话,就加载缓存
        String cache = CacheUtils.getCache(GlobalContants.GATE_GORY_URL,mActivity);
        //判断cache是否为空
        if(TextUtils.isEmpty(cache)){
            System.out.println("发现缓存啦");
            processData(cache);
        }else {
            //请求服务器,获取数据
            //开源框架xUtils
            getDataFromServer();
        }

        //修改页面标题
        tvTitle.setText("新闻大厅");
        //要给帧布局填充布局对象
        View view = View.inflate(mActivity, R.layout.newscenterpager,null);
        flContent.addView(view);//动态的给空白的帧布局添加一个布局对象

    }

    /**
     * 从服务器获取数据
     * 记得配置权限
     */
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        //url怎么办呢?为了方便,创建一个类把这个维护起来
        utils.send(HttpRequest.HttpMethod.GET, GlobalContants.GATE_GORY_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //请求成功
                String result = responseInfo.result;//获取服务器返回结果
                System.out.println("服务器返回结果:"+result);
                processData(result);
                //写缓存
                CacheUtils.setCache(GlobalContants.GATE_GORY_URL,result,mActivity);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                //请求失败
                error.printStackTrace();
                Toast.makeText(mActivity,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * 解析数据,使用第三方工具Gson
     */
    protected void processData(String json){
        //Gson:google json
        Gson gson = new Gson();
       NewsMenu data = gson.fromJson(json, NewsMenu.class);//为了获取创建一个包domain,
        System.out.println("解析结果:"+data);//这是打印的是地址,为了更好的观察,在NewsMenu中重写toString方法

        //获取侧边栏对象
    }
}
