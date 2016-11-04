package smartxinhua.com.smartxinhua.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

import smartxinhua.com.smartxinhua.MainActivity;
import smartxinhua.com.smartxinhua.R;
import smartxinhua.com.smartxinhua.base.BasePager;
import smartxinhua.com.smartxinhua.base.impl.GovPager;
import smartxinhua.com.smartxinhua.base.impl.HomePager;
import smartxinhua.com.smartxinhua.base.impl.NewsCenterPager;
import smartxinhua.com.smartxinhua.base.impl.SettingPager;
import smartxinhua.com.smartxinhua.base.impl.SmartServicePager;
import smartxinhua.com.smartxinhua.view.NoScrollViewPager;

/**
 * 主页面
 * Created by Zoe on 2016/11/2.
 */
public class ContentFragment extends BaseFragment {

    private NoScrollViewPager mViewPager;
    private ArrayList<BasePager> mPagers;//五个标签页的集合
    private RadioGroup rgGroup;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content,null);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
        rgGroup = (RadioGroup)view.findViewById(R.id.rg_group);
        return view;
    }
    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        //添加五个标签页
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsCenterPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new GovPager(mActivity));
        mPagers.add(new SettingPager(mActivity));

        //先写好ContentAdapter适配器,然后开始new一个
        mViewPager.setAdapter(new ContentAdapter());

        //给radioGroups设置一个点击监听事件,底栏标签的切换监听
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        //首页被选中
                        mViewPager.setCurrentItem(0,false);//参数2表示是否要切换动画
                        break;
                    case R.id.rb_news:
                        //新闻大厅
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_smart:
                        //成员介绍
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_gov:
                        //小灵聊天
                        mViewPager.setCurrentItem(3,false);
                        break;
                    case R.id.rb_setting:
                        //个人中心
                        mViewPager.setCurrentItem(4,false);
                        break;
                }
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BasePager  pager = mPagers.get(position);//先获取当前页面
                pager.initData();//然后初始化数据
                if(position == 0 || position == mPagers.size()-1){
                    //除新闻中心页面之外其他页面禁用侧边栏
                    setSlidingMenuEnable(false);
                }else {
                    //新闻中心开启侧边栏
                    setSlidingMenuEnable(true);
                }
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagers.get(0).initData();//手动加载第一页数据
        //首页禁用
        setSlidingMenuEnable(false);
    }

    /**
     * 开启或者禁用侧边栏
     * @param enable
     */
    protected void setSlidingMenuEnable(boolean enable) {
        //获取侧边栏对象
        MainActivity mainUI = (MainActivity)mActivity;
        SlidingMenu slidingMenu = mainUI.getSlidingMenu();
        if(enable){
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else{
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
    class ContentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;//获取当前页面对象的布局
            //mRooTView 是在BasePager中就定义了的.
            //pager.initData();//初始化数据,调用了basepager中的initData
            //viewpager会默认加载下一个页面,为了节省流量和性能,不在次数调用初始化性能
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);//通常都是直接调用removeView这个方法把objectremoved掉
        }
    }
}
