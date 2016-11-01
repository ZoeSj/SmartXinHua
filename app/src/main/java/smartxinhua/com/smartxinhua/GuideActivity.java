package smartxinhua.com.smartxinhua;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * 新手引导页
 * Created by Zoe on 2016/11/1.
 */
public class GuideActivity extends Activity {

    private ViewPager mViewPager;
    private LinearLayout llContainer;
    //怎样维护这个对象数组?
    private ArrayList<ImageView> mImageViewList;//imageview的集合
    //引导页图片id数组
    private int[] mImageIds = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    private ImageView ivRedPoint;//设置小红点
    private int mPointDis;//小红点移动的距离


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题,这个恶搞方法必须在setcontentview之前调用
        setContentView(R.layout.guide_activity);
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        ivRedPoint = (ImageView)findViewById(R.id.iv_red_point);
        initData();
        mViewPager.setAdapter(new GuideAdapter());//设置数据
        //设置页面滑动的一个监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //当页面滑动过程中的回调
                System.out.println("当前位置:"+position+";移动偏移百分百:"+positionOffset);
                //更新小红点的距离
            }

            @Override
            public void onPageSelected(int position) {
            //某个页面被选中
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            //页面状态发生变化的回调,暂时不用
            }
        });
        //计算两个小红点之间的距离
        //移动距离=第二个圆点left的值-第一个圆点left的值
        //measure->layout->draw(activity的 oncreate方法执行结束之后才走此流程,这就解释了为什么打印距离为0)
       /* mPointDis = llContainer.getChildAt(1).getLeft()-llContainer.getChildAt(0).getLeft();
        System.out.println("圆点距离:"+mPointDis); //因为打印距离是0,所以这个方法不能直接这样写*/
        //监听layout方法结束的事件.结束之后位置确定好之后再获取圆点间距
        //视图树?
        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);//避免重复回调
                //layout方法执行结束的回调,这时可以使用这个方法
                mPointDis = llContainer.getChildAt(1).getLeft()-llContainer.getChildAt(0).getLeft();
                System.out.println("圆点距离:"+mPointDis);
            }
        });

    }

    //初始化ImageViewer对象.初始化数据
    private void initData(){
        mImageViewList = new ArrayList<ImageView>();
        for (int i=0;i<mImageIds.length;i++){
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);//通过设置背景,可以让宽高填充布局
            //view.setImageResource(resId);这个方法不一定能填充满
            mImageViewList.add(view);
            //初始化小圆点
            ImageView point=new ImageView(this);
            point.setImageResource(R.drawable.shape_point_gray);//设置shape形状
            //初始化布局参数,宽高包裹内容,父控件是谁,就是谁声明的布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            if(i>0){
                //从第二个点开始设置左边距
                params.leftMargin=10;
            }
            point.setLayoutParams(params);
            llContainer.addView(point);//给容器添加圆点

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
