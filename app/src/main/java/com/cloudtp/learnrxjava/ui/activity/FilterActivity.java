package com.cloudtp.learnrxjava.ui.activity;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by JYD on 2016/9/1.
 */
public class FilterActivity  extends BaseActivity{
    @Override
    protected void registerAction() {
       String apiName=getIntent().getStringExtra("apiName");
        switch (apiName){
            case "filter":
                showApiDesc("Filter操作符使用你指定的一个谓词函数测试数据项，只有通过测试的数据才会被发射" +
                        "ofType是filter操作符的一个特殊形式。它过滤一个Observable只返回指定类型的数据。");
                Observable.range(1,5).filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer%2==0?true:false;
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("filter------>"+integer);
                    }
                });
                break;
            case "TakeLast":
                showApiDesc("使用TakeLast操作符修改原始Observable，" +
                        "你可以只发射Observable'发射的后N项数据，忽略前面的数据");
                Observable.range(1,10).takeLast(2).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("TakeLast---->"+integer);
                    }
                });
                break;
            case "last":
                showApiDesc("只发射最后一项数据,这个版本的last也是接受一个谓词函数，" +
                        "返回一个发射原始Observable中满足条件的最后一项数据的Observable。" +
                        "lastOrDefault与last类似，不同的是，如果原始Observable没有发射任何值，它发射你指定的默认值。");
                Observable.range(1,10).last().subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("last---->"+integer);
                    }
                });
                break;
            case "TakeLastBuffer":
                showApiDesc("还有一个操作符叫takeLastBuffer，它和takeLast类似，" +
                        "唯一的不同是它把所有的数据项收集到一个List再发射，而不是依次发射一个。");
                Observable.range(1,10).takeLastBuffer(3).subscribe(new Action1<List<Integer>>() {
                    @Override
                    public void call(List<Integer> integers) {
                        log("TakeLastBuffer---->"+integers);
                    }
                });
                break;
            case "skip":
                showApiDesc("使用Skip操作符，你可以忽略Observable'发射的前N项数据，只保留之后的数据。" +
                        "也可以丢弃一段时间内的原始数据");
                Observable.range(1,10).skip(6).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("skip----->"+integer);
                    }
                });
                break;
            case "skipLast":
                showApiDesc("使用SkipLast操作符修改原始Observable，你可以忽略Observable'发射的后N项数据，只保留前面的数据。" +
                        "也可以丢弃最后一段时间丢弃的数据");
                Observable.range(1,10).skipLast(5).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("skipLast------>"+integer);
                    }
                });
                break;
            case "take":
                showApiDesc("使用Take操作符让你可以修改Observable的行为，只返回前面的N项数据，然后发射完成通知，忽略剩余的数据。");
                Observable.range(1,10).take(5).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("take---->"+integer);
                    }
                });
                break;
            case "First":
                showApiDesc("如果你只对Observable发射的第一项数据，或者满足某个条件的第一项数据感兴趣，" +
                        "你可以使用First操作符" +
                        "传递一个谓词函数给first，然后发射这个函数判定为true的第一项数据。");
                Observable.range(2,5).first().subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("First----->"+integer);
                    }
                });
        }
    }
}