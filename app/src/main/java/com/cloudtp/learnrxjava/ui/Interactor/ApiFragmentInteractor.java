package com.cloudtp.learnrxjava.ui.Interactor;

import com.cloudtp.learnrxjava.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JYD on 2016/8/26.
 */
public interface ApiFragmentInteractor {
    ArrayList<String> getData(Constant.NewsType type);
}
