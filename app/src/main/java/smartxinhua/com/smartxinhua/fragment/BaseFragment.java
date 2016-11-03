package smartxinhua.com.smartxinhua.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zoe on 2016/11/2.
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivity;

    //fragment创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();//获取当前Fragment所依赖的Activity

    }

    //初始化Fragment的布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = initView();
        return view;
    }

    //fragment所依赖的Activity的oncreate方法执行结束
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化数据
        initData();
    }

    //初始化布局,必须由子类去实现
    public abstract void initData();

    //初始化布局,必须由子类去实现
    public abstract View initView();
}
