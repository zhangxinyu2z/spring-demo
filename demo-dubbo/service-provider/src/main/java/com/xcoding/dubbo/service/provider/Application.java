package com.xcoding.dubbo.service.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangxinyu
 * @date 2023/5/16
 **/
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-service-provider"
            + ".xml");
        context.start();

        System.out.println("dubbo service started");
        // to hang up main thread
        new CountDownLatch(1).await();


        // 使用dubbo的启动方式
        // Main.main(new String[]{"spring","log4j"});
    }
}
