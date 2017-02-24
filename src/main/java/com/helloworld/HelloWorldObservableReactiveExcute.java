package com.helloworld;

import rx.Observable;
import rx.Observer;

/**
 * Created by fangjinzi on 2017/1/22.
 */
public class HelloWorldObservableReactiveExcute {
    public void testObservable() {
        Observable<String> observer = new HelloWorldHystrixObservableCommand("World").observe();
        observer.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("observer of ObservableCommand completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("observer of ObservableCommand error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("observer of ObservableCommand next: " + s);
            }
        });
    }
}
