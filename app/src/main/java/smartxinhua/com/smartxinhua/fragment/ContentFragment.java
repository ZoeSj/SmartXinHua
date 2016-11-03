package smartxinhua.com.smartxinhua.fragment;

import android.view.View;

import smartxinhua.com.smartxinhua.R;

/**
 * 主页面
 * Created by Zoe on 2016/11/2.
 */
public class ContentFragment extends BaseFragment {
    @Override
    public void initData() {


    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content,null);
        return view;
    }
}
