package com.z2xinyu.aop.config;

import com.z2xinyu.aop.aspect.coding.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/** 演唱会配置 */
@Configuration
// 这一步等于xml中的<aop:aspectj-autoproxy />，将@Aspect注解的bean视为切面，进行解析，创建切面的代理
@EnableAspectJAutoProxy
// 扫描aop包下类上有@Component
@ComponentScan("com.z2xinyu.aop.aspect.coding")
public class ConcertConfig {

    // 没有@Componet需要手动注入容器
    @Bean
    public Audience audience() {
        return new Audience();
    }
}
