package com.cloudtp.learnrxjava.ui.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cloudtp.learnrxjava.MainFragment;
import com.cloudtp.learnrxjava.MainFragmentInteractor;
import com.cloudtp.learnrxjava.Presenter;
import com.cloudtp.learnrxjava.constant.Constant;
import com.cloudtp.learnrxjava.ui.Interactor.ApiFragmentInteractor;
import com.cloudtp.learnrxjava.ui.Interactor.impl.ApiFragmentInteractorImpl;
import com.cloudtp.learnrxjava.ui.fragmentapi.ApiListFragment;

/**
 * Created by JYD on 2016/8/25.
 */
public class ApiListFragmentPresenter {
    private Context mContext = null;
    private ApiListFragment mView = null;
    private ApiFragmentInteractor mInteractor = null;
    public ApiListFragmentPresenter(Context context, @NonNull ApiListFragment newsView){
        mContext=context;
        mView=newsView;
        mInteractor=new ApiFragmentInteractorImpl();
    }


    public void initialized(Constant.NewsType type) {
       mView.initializeViews( mInteractor.getData(type));
    }
}
