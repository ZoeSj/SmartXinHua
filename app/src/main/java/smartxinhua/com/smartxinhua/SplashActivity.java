package smartxinhua.com.smartxinhua;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * 闪屏页面
 * Created by Zoe on 2016/11/1.
 */
public class SplashActivity extends Activity{

    private RelativeLayout rlroot;
    private RotateAnimation animRotat;
    private AlphaAnimation animAlpha;
    private ScaleAnimation animScale;
    private AnimationSet set;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        rlroot = (RelativeLayout)findViewById(R.id.rl_root);
        //这里添加了动画属性,旋转动画
        animRotat = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animRotat.setDuration(1000);//动画时间
        animRotat.setFillAfter(true);//保持动画结束状态
        //缩放动画
        animScale = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animScale.setDuration(1000);//设置动画时间
        animScale.setFillAfter(true);//保持动画结束状态
        //渐变动画
        animAlpha = new AlphaAnimation(0,1);
        animAlpha.setDuration(2000);//设置动画时间
        animAlpha.setFillAfter(true);//保持动画结束状态
        //动画集合
        set = new AnimationSet(true);
        set.addAnimation(animRotat);
        set.addAnimation(animScale);
        set.addAnimation(animAlpha);
        //启动动画
        rlroot.startAnimation(set);
    }
}
