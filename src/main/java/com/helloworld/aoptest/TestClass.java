package com.helloworld.aoptest;

import static java.lang.Thread.sleep;

/**
 * Created by fangjinzi on 2017/2/15.
 */
public class TestClass {
    public Integer run(){
        double d = Math.random();
        long num = (long)(d*1000);
        try {
            sleep(num);
        } catch (Exception e) {
            System.out.println("sleep fail");
        }
        if (num > 500) {
            return 0;
        } else {
            return 1;
        }
    }
}
