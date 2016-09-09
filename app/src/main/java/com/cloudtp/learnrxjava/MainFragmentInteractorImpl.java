package com.cloudtp.learnrxjava;

/**
 * Created by cloudtp on 2016/8/24.
 */
public class MainFragmentInteractorImpl implements MainFragmentInteractor {

    @Override
    public String[] getData() {

         return new String[]{"ALL",
                "创建Observable", "tranform变化", "filter过滤", "combining结合操作"};
    }
}
