package com.zsw.userprovider.hystrix;

import java.text.SimpleDateFormat;

/**
 * 观察者模式测试
 *
 * @author zhangshiwei
 * @since 2020年10月20日 下午4:12:10
 */
public class ObserverDemo {
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String[]        list             = new String[] { "幼儿园", "小 学", "初 中", "高 中", "大 学", "毕 业" };

    //    private static final Action0         completedAction  = new Action0() {
    //                                                              @Override
    //                                                              public void call() {
    //                                                                  System.out.println(
    //                                                                          "completedAction call completed ------ 时间: "
    //                                                                                  + simpleDateFormat
    //                                                                                          .format(new Date()));
    //                                                              }
    //                                                          };
    //
    //    public static void main(String[] args) {
    //        // 被观察者
    //        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
    //            @Override
    //            public Observable<String> call() {
    //                System.out.println("被观察者observable call ------ 时间: " + simpleDateFormat.format(new Date()));
    //
    //                Observable observable1 = Observable.from(list);
    //                return observable1.doOnCompleted(completedAction);
    //            }
    //        });
    //
    //        // 观察者
    //        Observer<String> observer = new Observer<String>() {
    //            @Override
    //            public void onCompleted() {
    //                System.out.println("观察者observer onCompleted ------ 时间: " + simpleDateFormat.format(new Date()));
    //            }
    //
    //            @Override
    //            public void onError(Throwable e) {
    //                System.out.println("观察者observer onError ------ 时间: " + simpleDateFormat.format(new Date()));
    //            }
    //
    //            @Override
    //            public void onNext(String s) {
    //                System.out
    //                        .println(s + "   ###### 观察者observer onNext ------ 时间: " + simpleDateFormat.format(new Date()));
    //            }
    //        };
    //
    //        // 观察者 与 被观察者 : 建立订阅关系
    //        observable.subscribe(observer);
    //
    //        // 建立订阅关系的另一种写法
    //        observable.toBlocking().toFuture();
    //    }

}
