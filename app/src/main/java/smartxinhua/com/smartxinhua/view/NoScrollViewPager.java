package smartxinhua.com.smartxinhua.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 这个是自定义的viewpager
 * 主功能就是不允许滑动
 * Created by Zoe on 2016/11/3.
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //重写此方法,触摸时什么都不做,从而实现对滑动事件的禁用
        return true;
    }
}
