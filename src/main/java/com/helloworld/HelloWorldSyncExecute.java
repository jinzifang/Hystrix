package com.helloworld;

import static org.junit.Assert.assertEquals;

/**
 * Created by fangjinzi on 2017/1/22.
 */
public class HelloWorldSyncExecute {
    public void testSynchronous() {
        assertEquals("Hello World!", new HelloWorldHystrixCommand("World").execute());
    }
}
