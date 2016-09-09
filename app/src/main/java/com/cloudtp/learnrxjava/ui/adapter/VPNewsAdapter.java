package com.cloudtp.learnrxjava.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtp.learnrxjava.R;
import com.cloudtp.learnrxjava.ui.fragmentapi.ApiListFragment;
import com.cloudtp.learnrxjava.constant.Constant;
import com.yuyh.library.view.viewpager.indicator.FragmentListPageAdapter;
import com.yuyh.library.view.viewpager.indicator.IndicatorViewPager;

/**
 * Created by Kyrie.Y on 2016/6/6.
 */
public class VPNewsAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
    private LayoutInflater inflate;
    private String[] names;

    public VPNewsAdapter(Context context, String[] names, FragmentManager fragmentManager) {
        super(fragmentManager);
        inflate = LayoutInflater.from(context);
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.tab_nba_news, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(names[position % names.length]);
        int padding = 15;//DimenUtils.dpToPxInt(15);
        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        ApiListFragment fragment = new ApiListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(fragment.INTENT_INT_INDEX, position);
        Constant.NewsType apiTypeBundle;
        switch (position) {
            case 0:
                apiTypeBundle = Constant.NewsType.ALL;
                break;
            case 1:
                apiTypeBundle = Constant.NewsType.CREATING;
                break;
            case 2:
                apiTypeBundle = Constant.NewsType.TRANSFORM;
                break;
            case 3:
                apiTypeBundle = Constant.NewsType.FILTER;
                break;
            case 4:
            default:
                apiTypeBundle = Constant.NewsType.COMBINING;
                break;
        }
        bundle.putSerializable(fragment.INTENT_INT_INDEX, apiTypeBundle);
       fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        return FragmentListPageAdapter.POSITION_NONE;
    }
}
