package com.cloudtp.learnrxjava;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by cloudtp on 2016/8/24.
 */
public class MainFragmentPresenter implements Presenter{
    private Context mContext = null;
    private MainFragment mView = null;
    private MainFragmentInteractor mInteractor = null;
    public MainFragmentPresenter(Context context, @NonNull MainFragment newsView) {
        mContext = context;
        mView = newsView;
        mInteractor = new MainFragmentInteractorImpl();
    }
    @Override
    public void initialized() {
        mView.initializeViews(mInteractor.getData());
    }
}
