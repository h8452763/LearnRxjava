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
public class CreatingObservableFragment extends Fragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View infalter=inflater.inflate(R.layout.fragment_creating,container,false);
        unbinder= ButterKnife.bind(this,infalter);
        return infalter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
