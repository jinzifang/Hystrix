package com.helloworld;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * Created by fangjinzi on 2017/1/22.
 */

/**
 * observe() — returns a “hot” Observable that executes the command immediately,
 * though because the Observable is filtered through a ReplaySubject you are not in danger of losing any items that it emits before you have a chance to subscribe
 * toObservable() — returns a “cold” Observable that won’t execute the command and begin emitting its results until you subscribe to the Observable
 */

public class HelloWorldReactiveExecute {
    public void testReactiveExcute() {
        //observe() 异步非阻塞执行
        Observable<String> world = new HelloWorldHystrixCommand("World").observe();
        Observable<String> fbob = new HelloWorldHystrixCommand("bob").observe();
        //阻塞执行single
        System.out.println("Single run result: " + world.toBlocking().single());

        //注册观察者事件
        // non-blocking
        // - this is a verbose anonymous inner-class approach and doesn't do assertions
        world.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("run complete");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("run next" + s);
            }
        });

        // non-blocking
        // - also verbose anonymous inner-class, ignore errors and onCompleted signal
        world.subscribe(new Action1<String>() {
            //相当于上面的onNext
            @Override
            public void call(String s) {
                System.out.println("call: " + s);
            }
        });
    }

    public void testReactiveExcuteTo() {
        Observable<String> coldObserver = new HelloWorldHystrixCommand("World").toObservable();

        coldObserver.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("coldobserver complete");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("coldobserver error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("coldobserver onnext: " + s);
            }
        });
    }
}
