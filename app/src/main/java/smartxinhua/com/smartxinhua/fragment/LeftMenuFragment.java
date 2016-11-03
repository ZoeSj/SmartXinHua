package smartxinhua.com.smartxinhua.fragment;

import android.view.View;

import smartxinhua.com.smartxinhua.R;

/**
 * 侧边栏Fragment
 * Created by Zoe on 2016/11/2.
 */
public class LeftMenuFragment extends BaseFragment {

    private View view;

    @Override
    public void initData() {

    }

    @Override
    public View initView() {
        view = View.inflate(mActivity, R.layout.fragment_left_menu,null);
        return view;

    }
}
