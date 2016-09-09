package com.cloudtp.learnrxjava.ui.fragmentapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtp.learnrxjava.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by cloudtp on 2016/8/22.
 */
public class TranformingFragment extends Fragment {
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_tranforming,container,false);
        unbinder= ButterKnife.bind(this,layout);
        return layout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
