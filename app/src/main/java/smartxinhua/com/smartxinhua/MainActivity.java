package smartxinhua.com.smartxinhua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题,这个恶搞方法必须在setcontentview之前调用
        setContentView(R.layout.activity_main);
    }
}
