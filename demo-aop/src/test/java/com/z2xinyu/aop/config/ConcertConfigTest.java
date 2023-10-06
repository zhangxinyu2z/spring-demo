package com.z2xinyu.aop.config;

import com.z2xinyu.aop.aspect.coding.Audience;
import com.z2xinyu.aop.concert.Encoreable;
import com.z2xinyu.aop.concert.Performance;
import com.z2xinyu.aop.concert.PerformanceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 经过测试，performance和encoreable被同一个代理对象代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConcertConfig.class})
public class ConcertConfigTest {

    @Autowired
    private Performance performance;

    @Autowired
    private Encoreable encoreable;

    @Test
    public void proxyTest() {
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(new PerformanceImpl());
        factory.addAspect(new Audience());
        Performance proxy = factory.getProxy();
        proxy.performance("智取威虎山");
    }

    @Test
    public void run() {
        // 测试通知
        performance.performance("西门庆大闹大观园");

        // 测试引入的接口方法
        Encoreable performance1 = (Encoreable) this.performance;
        performance1.performEncore();

        Performance encoreable = (Performance) this.encoreable;
        encoreable.performance("贾宝玉风雪山神庙");

    }

}