package smartxinhua.com.smartxinhua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import smartxinhua.com.smartxinhua.utils.PrefUtils;

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
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束,跳转页面
                //如果是第一次进入,进入新手引导页
                //否则跳转到主页面
               /* SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
                Boolean isFirstEnter = sp.getBoolean("is_first_enter",true);*/

                Boolean isFirstEnter = PrefUtils.getBoolean(SplashActivity.this,"is_first_enter",true);
                Intent intent;
                if(isFirstEnter){
                    //跳到新手引导页面
                intent = new  Intent(getApplicationContext(),GuideActivity.class);
                }else
                {
                    //跳到主页面
                    intent = new  Intent(getApplicationContext(),MainActivity.class);
                }
                startActivity(intent);
                finish();//结束当前闪屏应用
            }

        });
    }
}
