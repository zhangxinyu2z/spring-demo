package com.z2xinyu.aop.aspect.coding;

import com.z2xinyu.aop.concert.DefaultEncoreable;
import com.z2xinyu.aop.concert.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * introduction: 引入，
 * 为Performance的子类对象引入新的接口方法，实际上是代理对象暴露了新的接口
 *
 * Spring In Action 4.3.4
 * 通过注解引入新功能 ： https://potoyang.gitbook.io/spring-in-action-v4/untitled/untitled-3/untitled-1
 */
@Aspect
@Component
public class EncoreableIntroducer {
    // Performance的子类型会引入该接口，引入功能的实现类是DefaultEncoreable
    @DeclareParents(value = "com.z2xinyu.aop.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
