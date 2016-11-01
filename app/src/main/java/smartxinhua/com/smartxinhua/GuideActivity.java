package smartxinhua.com.smartxinhua;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * 新手引导页
 * Created by Zoe on 2016/11/1.
 */
public class GuideActivity extends Activity {

    private ViewPager mViewPager;
    //怎样维护这个对象数组?
    private ArrayList<ImageView> mImageViewList;//imageview的集合
    //引导页图片id数组
    private int[] mImageIds = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题,这个恶搞方法必须在setcontentview之前调用
        setContentView(R.layout.guide_activity);
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        initData();
        mViewPager.setAdapter(new GuideAdapter());//设置数据
    }

    //初始化ImageViewer对象.初始化数据
    private void initData(){
        mImageViewList = new ArrayList<ImageView>();
        for (int i=0;i<mImageIds.length;i++){
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);//通过设置背景,可以让宽高填充布局
            //view.setImageResource(resId);这个方法不一定能填充满
            mImageViewList.add(view);
        }
    }
    class GuideAdapter extends PagerAdapter{
        @Override
        //返回item的个数
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        //初始化item的布局
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = mImageViewList.get(position);//获取这个ImageViewer,之前通过集合已经把要使用的创建好了,用的时候直接拿过来用
            container.addView(view);//把这个对象塞给container容器
            return view;
        }

        @Override
        //销毁item布局
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View)object);
        }
    }
}
