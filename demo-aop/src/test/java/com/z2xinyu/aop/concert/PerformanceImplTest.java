package com.z2xinyu.aop.concert;

import com.z2xinyu.aop.SpringDemoAopApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PerformanceImplTest extends SpringDemoAopApplicationTest {

    @Autowired
    private PerformanceImpl performanceImpl;

    @Test
    public void perform() {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo-aop-start.xml");
        // Performance performanceImpl = (Performance)context.getBean("performanceImpl");
        performanceImpl.performance("智取威虎山");
    }
}