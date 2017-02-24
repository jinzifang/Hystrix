package com.helloworld.aoptest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.servopublisher.HystrixServoMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.stereotype.Component;

/**
 * Created by fangjinzi on 2017/2/16.
 */
@Component
public class ServiceClass extends TestClass{
    @Override
    @HystrixCommand(fallbackMethod="fallService",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "500")})
    public Integer run(){
        System.out.println("service run");
        return super.run();
    }

    private Integer fallService() {
        System.out.println("run Fallback" + this.getClass().getSuperclass().getName() + ": " +
        Thread.currentThread().getStackTrace()[2].getMethodName());
        HystrixPlugins.getInstance().registerMetricsPublisher(HystrixServoMetricsPublisher.getInstance());
        return 0;
    }
}
