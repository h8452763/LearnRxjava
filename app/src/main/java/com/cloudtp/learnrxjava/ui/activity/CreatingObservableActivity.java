package com.cloudtp.learnrxjava.ui.activity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by JYD on 2016/8/29.
 */
public class CreatingObservableActivity extends BaseActivity{
    @Override
    protected void registerAction() {

        String apiName = getIntent().getStringExtra("apiName");
        switch (apiName) {
            case "just":
            Observable.just(1, 2, 3).subscribe(new Action1<Integer>() {
                @Override
                public void call(Integer integer) {
                    log(integer.toString());
                }
            });
            showApiDesc("创建一个发射指定值的Observable");
            showApiText("    Observable.just(1, 2, 3).subscribe(new Action1<Integer>() {\n" +
                    "      @Override\n" +
                    "      public void call(Integer integer) {\n" +
                    "        log(integer);\n" +
                    "      }\n" +
                    "    });\n");
                break;
            case "from":
                String[] words = {"Hello", "Hi", "Aloha"};
                Observable.from(words).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        log(s);
                    }
                });
                showApiDesc("将其它种类的对象和数据类型转换为Observable\n"+
                        "将传入的数组或 Iterable 拆分成具体对象后，依次发送出来\n");
                showApiText(
                        "String[] words = {Hello, Hi, Aloha};\n"+
                "Observable.from(words).subscribe(new Action1<String>() {\n"+
                 "  @Override\n"+
                 " public void call(String s) {\n"+
                 " log(s);\n"+
                 "   }\n"+
                 " });\n"
        );
                break;
            case "repeat":
                Observable.just(1,2).repeat(2).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("result-------->"+integer);
                    }
                });
                showApiDesc("创建一个发射特定数据重复多次的Observable\n"+
                "repeat操作符就是对某一个Observable重复产生多次结果,当repeat() 接收到onComplete()会触发重订阅，默认情况下运行在一个新的线程上\n");
                showApiText(
                        "Observable.just(1,2).repeat(2).subscribe(new Action1<Integer>() {\n"+
                            "@Override\n"+
                            "public void call(Integer integer) {\n"+
                                "log("+"result-------->"+"integer);\n"+
                            "}\n"+
                        "});\n"
                );
                break;
            case "repeatWhen":
                showApiText(
                        "Observable.just(1,2).repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {"+
                "@Override"+
                "public Observable<?> call(Observable<? extends Void> observable) {"+
                    "return Observable.timer(3, TimeUnit.SECONDS);"+
                "}"+
            "}).subscribe(new Action1<Integer>() {"+
                "@Override"+
                "public void call(Integer integer) {"+
                    "log("+"------->"+"integer);"+
                "}"+
            "});"
                );
                showApiDesc("就是可以让订阅者多次订阅，如:第一次订阅1-2 间隔3秒后又会重新订阅一次\n"+
                "它不是缓存和重放原始Observable的数据序列，而是有条件的重新订阅和发射原来的Observable");
                Observable.just(1,2).repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Void> observable) {
                        return Observable.timer(3, TimeUnit.SECONDS);
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("------->"+integer);
                    }
                });
                break;
            case "create":
                showApiDesc("使用一个函数从头开始创建一个Observable");
                Observable.create(new Observable.OnSubscribe<Object>() {
                    @Override
                    public void call(Subscriber<? super Object> subscriber) {
                        subscriber.onNext("hello");
                        subscriber.onNext("rxJava");
                    }
                }).subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        log("----->"+o);
                    }
                });
                break;
            case "defer":
                showApiDesc("直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable"+
                "just操作符是在创建Observable就进行了赋值操作，而defer是在订阅者订阅时才创建Observable，此时才进行真正的赋值操作");
                Observable justObservable=Observable.just(System.currentTimeMillis());
                final Observable deferObservable=Observable.defer(new Func0<Observable>() {
                    @Override
                    public Observable call() {
                        return Observable.just(System.currentTimeMillis());
                    }
                });
                justObservable.subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        log("---->"+o);
                    }
                });
                deferObservable.subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        log("---->"+o);
                    }
                });
                break;
            case "range":
                showApiDesc("创建一个发射特定整数序列的Observable"+
                "Range操作符发射一个范围内的有序整数序列，你可以指定范围的起始和长度");
                Observable.range(2,2).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        log("------>"+integer);
                    }
                });
                break;
            case "interval":
                showApiDesc("创建一个按固定时间间隔发射整数序列的Observable"+
                        "通过unsubscribe结束");
                Observable.interval(3,2,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        log("------>"+aLong);
                    }
                });
                break;
            case "timer":
                showApiDesc("timer一种是隔一段时间产生一个数字，然后就结束");
                Observable.timer(1,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        log("------->"+aLong);
                    }
                });
                break;
            case "empty":
                showApiDesc("不常用，创建一个不发射任何数据但是正常终止的Observable");
                break;
            case "error":
                showApiDesc("不常用，创建一个不发射数据也不终止的Observable");
                break;
            case "never":
                showApiDesc("不常用，创建一个不发射数据以一个错误终止的Observable");
                break;
            default:
                break;
        }

    }

}
