package com.cloudtp.learnrxjava.ui.activity;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

/**
 * Created by JYD on 2016/8/31.
 */
public class TransFromActivity extends BaseActivity {
    @Override
    protected void registerAction() {
        String apiName = getIntent().getStringExtra("apiName");
        switch (apiName){
            case "map":
                showApiText("非常常用,特别常用，对Observable发射的每一项数据应用一个函数，执行变换操作"+
                "Map操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果的Observable。");
                Observable.just(1,3,6).map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer*2;
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("----->"+integer);
                    }
                });
                break;
            case "flatmap":
                showApiText("FlatMap是个比较难懂的变换，也是比较常用的变换需要好好实践理解" +
                        "FlatMap将一个发射数据的Observable变换为多个Observables，" +
                        "然后将它们发射的数据合并后放进一个单独的Observable");
                Observable.just(1,4,6).flatMap(new Func1<Integer, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Integer integer) {
                        return Observable.just(integer);
                    }
                }).subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        log("------->"+o);
                    }
                });
                break;
            case "concatMap":

                break;
            case "switchmap":
                showApiText("");

                break;
            case "scan":
                showApiDesc("连续地对数据序列的每一项应用一个函数，然后连续发射结果Scan操作符" +
                        "对原始Observable发射的第一项数据应用一个函数，" +
                        "然后将那个函数的结果作为自己的第一项数据发射。" +
                        "它将函数的结果同第二项数据一起填充给这个函数来产生它自己的第二项数据");
                Observable.just(1,2,3).scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer+integer2;
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("scan-->"+integer);
                    }
                });
                break;
            case "groupBy":
                showApiDesc("将一个Observable分拆为一些Observables集合，它们中的每一个发射原始Observable的一个子序列" +
                        "将Observable分拆为Observable集合，将原始Observable发射的数据按Key分组，每一个Observable发射一组不同的数据");
                Observable.range(1,3).groupBy(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer%2==0?"even":"odd";
                    }
                }).subscribe(new Action1<GroupedObservable<String, Integer>>() {
                    @Override
                    public void call(GroupedObservable<String, Integer> stringIntegerGroupedObservable) {
                        log("groupBy------>"+stringIntegerGroupedObservable.getKey());
                        stringIntegerGroupedObservable.subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                log("string--->"+integer);
                            }
                        });
                    }
                });
                break;
            case "buffer":
                showApiDesc("定期收集Observable的数据放进一个数据包裹，然后发射这些数据包裹，而不是一次发射一个值。");
               Observable.range(1,10).buffer(2,3).subscribe(new Action1<List<Integer>>() {
                   //输出的是没隔三个数输出两个
                   String result=null;
                   @Override
                   public void call(List<Integer> integers) {
                       for(Integer integer:integers){
                           result+=integer;
                       }
                       log("buffer"+result);
                   }
               });
                break;
            case "window":
                showApiDesc("定期将来自原始Observable的数据分解为一个Observable窗口，发射这些窗口，而不是每次发射一项数据");
                Observable.range(1,5).window(3).subscribe(new Action1<Observable<Integer>>() {
                    @Override
                    public void call(Observable<Integer> integerObservable) {
                        integerObservable.subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                log("window---->"+integer);
                            }
                        });
                    }
                });
                break;
            case "cast":
                showApiDesc("cast在发射之前强制将Observable发射的所有数据转换为指定类型" +
                        "属于map的特殊版");
                break;
            default:
                break;
        }
    }
}
