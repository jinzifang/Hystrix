package com.helloworld;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by fangjinzi on 2017/1/22.
 */

/**
 * HystrixObservableCommand 和 HystrixCommand 的区别，简单的理解多返回的封装。
  HystrixObservableCommand is a specialized version of HystrixCommand meant to wrap Observables.
  A HystrixObservableCommand is capable of wrapping Observables that emit multiple items, whereas ordinary HystrixCommands,
  even when converted into Observables, will never emit more than one item.
  In such a case, instead of overriding the run method with your command logic (as you would with an ordinary HystrixCommand),
  you would override the construct method so that it returns the Observable you intend to wrap.
 */

public class HelloWorldHystrixObservableCommand extends HystrixObservableCommand<String>{
    private final String name;

    public HelloWorldHystrixObservableCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }
    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        observer.onNext("Hello " + name + "!");
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }
}
