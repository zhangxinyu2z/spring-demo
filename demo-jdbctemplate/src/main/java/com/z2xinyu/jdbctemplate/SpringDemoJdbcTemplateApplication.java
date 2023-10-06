package com.z2xinyu.jdbctemplate;

import com.z2xinyu.jdbctemplate.config.JdbcConfiguration;
import com.z2xinyu.jdbctemplate.config.TxManagerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 使用编码的方式代替xml文件的配置
 * @author zhangxinyu
 * @date 2023/7/6
 **/
@Configuration
// 扫描@Component @Configuration
@ComponentScan
// spring4.2后@import可以导入普通类
@Import({JdbcConfiguration.class, TxManagerConfiguration.class})
// 开启AOP自动代理支持
@EnableAspectJAutoProxy
// 开启事务注解支持
@EnableTransactionManagement
public class SpringDemoJdbcTemplateApplication {
}
