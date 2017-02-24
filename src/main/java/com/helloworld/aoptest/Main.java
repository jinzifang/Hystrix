package com.helloworld.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fangjinzi on 2017/2/16.
 */
public class Main {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        TestClass testRun = (TestClass)context.getBean("testRun");
        System.out.println("Start fallback test");
        for (int i = 0; i < 5; i++) {
            try {
                if (testRun.run() > 0) {
                    System.out.println("run success");
                } else {
                    System.out.println("run timeout");
                }
            }catch (Exception e) {
                System.out.println("catch exception");
            }
        }
    }
}
