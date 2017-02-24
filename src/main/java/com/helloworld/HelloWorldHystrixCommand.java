package com.helloworld;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by fangjinzi on 2017/1/22.
 */
public class HelloWorldHystrixCommand extends HystrixCommand<String>{
    private final String name;
    public HelloWorldHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }

    @Override
    protected String getFallback() {
        return "Hello fail " + name + "!";
    }
}
