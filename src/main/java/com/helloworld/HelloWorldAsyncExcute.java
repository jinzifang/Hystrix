package com.helloworld;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by fangjinzi on 2017/1/22.
 */
public class HelloWorldAsyncExcute {
    public void testAsynchronous() {
        try {
            Future<String> fs = new HelloWorldHystrixCommand("World").queue();
            //do some thing
            assertEquals("Hell World!", fs.get());
        } catch (Exception e) {
            System.out.println("future get error");
        }
    }
}
