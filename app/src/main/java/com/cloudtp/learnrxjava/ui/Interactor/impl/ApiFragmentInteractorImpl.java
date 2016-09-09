package com.cloudtp.learnrxjava.ui.Interactor.impl;

import com.cloudtp.learnrxjava.constant.Constant;
import com.cloudtp.learnrxjava.ui.Interactor.ApiFragmentInteractor;
import com.cloudtp.learnrxjava.ui.adapter.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JYD on 2016/8/26.
 */
public class ApiFragmentInteractorImpl implements ApiFragmentInteractor {
    public ArrayList<String> apiList;
    public ArrayList<String> allList;
    private ArrayList<String> creatingData;
    private ArrayList<String> transformData;
    private ArrayList<String> filterData;
    private ArrayList<String> combiningData;

    @Override
    public ArrayList<String> getData(Constant.NewsType type) {
        switch (type) {
            case ALL:
                apiList = getAllData();
                break;
            case CREATING:
                apiList = getCreatingData();
                break;
            case TRANSFORM:
                apiList = getTransformData();
                break;
            case FILTER:
                apiList = getFilterData();
                break;
            case COMBINING:
                apiList = getCombiningData();
                break;
            default:
                ;
        }
        return apiList;
        /*return new String[]{
                "just","form","repeat","repeatWhen","create","defer","range",
                "interval","timer","empty","error","never"
        };*/
    }

    private ArrayList<String> getAllData() {
        allList=new ArrayList<>();
        allList.addAll(getCreatingData());
        allList.addAll(getTransformData());
        allList.addAll(getFilterData());
        allList.addAll(getCombiningData());
        return allList;
    }

    public ArrayList<String> getCreatingData() {
        creatingData=new ArrayList<>();
        creatingData.add("just");
        creatingData.add("from");
        creatingData.add("repeat");
        creatingData.add("repeatWhen");
        creatingData.add("create");
        creatingData.add("defer");
        creatingData.add("range");
        creatingData.add("interval");
        creatingData.add("timer");
        creatingData.add("empty");
        creatingData.add("error");
        creatingData.add("never");
        return creatingData;
    }

    public ArrayList<String> getTransformData() {
        transformData=new ArrayList<>();
        transformData.add("map");
        transformData.add("flatmap");
        transformData.add("switchmap");
        transformData.add("scan");
        transformData.add("groupBy");
        transformData.add("buffer");
        transformData.add("window");
        transformData.add("cast");
        return transformData;
    }

    public ArrayList<String> getFilterData() {
        filterData=new ArrayList<>();
        filterData.add("filter");
        filterData.add("takeLast");
        filterData.add("Last");
        filterData.add("takeLastBuffer");
        filterData.add("takeLastBuffer");
        filterData.add("skip");

        return filterData;
    }

    public ArrayList<String> getCombiningData() {
        combiningData=new ArrayList<>();
        combiningData.add("startWith");
        combiningData.add("merge");
        combiningData.add("mergeDelayError");
        combiningData.add("zip");
        combiningData.add("and,then,when");
        combiningData.add("combineLatest");
        combiningData.add("join,groupJoin");
        combiningData.add("switchOnnext");
        return combiningData;
    }
}
