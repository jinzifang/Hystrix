package com.helloworld.aoptest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by fangjinzi on 2017/2/15.
 */
@Deprecated
public class NormalHystrixAspect {
    @Autowired
    private TestClass testRun = new TestClass();

    @HystrixCommand(groupKey = "HystrixTest", commandKey = "HystrixFallbackTest", fallbackMethod = "runFallback",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    public Integer run() throws Exception {
        return testRun.run();
    }

    private Integer runFallback() {
        System.out.println("run Fallback");
        return 0;
    }
}
