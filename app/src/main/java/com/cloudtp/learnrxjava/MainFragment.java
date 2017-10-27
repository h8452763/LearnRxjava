package com.cloudtp.learnrxjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.cloudtp.learnrxjava.base.BaseLazyFragment;
import com.cloudtp.learnrxjava.ui.adapter.VPNewsAdapter;
import com.yuyh.library.view.viewpager.indicator.IndicatorViewPager;
import com.yuyh.library.view.viewpager.indicator.ScrollIndicatorView;
import com.yuyh.library.view.viewpager.indicator.slidebar.DrawableBar;
import com.yuyh.library.view.viewpager.indicator.slidebar.ScrollBar;
import com.yuyh.library.view.viewpager.indicator.transition.OnTransitionTextListener;

import butterknife.Unbinder;

/**
 * Created by cloudtp on 2016/8/12.
 */
public class MainFragment extends BaseLazyFragment implements FragmentView {
    private IndicatorViewPager indicatorViewPager;
    private ScrollIndicatorView scrollIndicatorView;
    private Unbinder unbinder;
    /*   @BindView(R.id.viewPager)
       ViewPager viewPager;
       @BindView(R.id.tableLayout)
       TabLayout tabLayout;*/
    public MainFragment(){

    }
    public static MainFragment getInstance(){
        return new MainFragment();
    }


    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_main);
        Presenter presenter = new MainFragmentPresenter(mActivity, this);
        presenter.initialized();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       initData();
    }

    private void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void initializeViews(String[] names) {
        scrollIndicatorView = (ScrollIndicatorView) findViewById(R.id.api_indicator);
        scrollIndicatorView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        scrollIndicatorView.setScrollBar(new DrawableBar(mActivity, R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - 12;
              //  DimenUtils.dpToPxInt(12);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - 12;
               // DimenUtils.dpToPxInt(12);
            }
        });
        scrollIndicatorView.setSplitAuto(true);
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(getResources().getColor(R.color.colorPrimary), Color.WHITE));

        ViewPager viewPager = (ViewPager) findViewById(R.id.api_viewPager);
        viewPager.setOffscreenPageLimit(names.length);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        indicatorViewPager.setAdapter(new VPNewsAdapter(mActivity, names, getChildFragmentManager()));
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mActivity.invalidateOptionsMenu();

        }
    }

    @Override
    protected void onPauseLazy() {
        super.onPauseLazy();
      //  JCVideoPlayer.releaseAllVideos();
    }
}
