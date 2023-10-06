package com.z2xinyu.jdbctemplate.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Arnoer
 * @since 2022/9/29 9:24
 */
// 标识配置类，@ComponentScan扫描加载
//@Configuration
// 加载配置文件
@PropertySource(value = "classpath:jdbc.properties")
public class JdbcConfiguration {

    /*
      @Value可以用来注入外部文件属性值
      1、$ 用来读取配置文件中的属性值
      2、不用$ 直接注入默认值
      3、# 可以注入SpEL表达式进行计算
     */

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // demo  运行机器的核心数
    @Value("#{T(java.lang.Runtime).getRuntime().availableProcessors()}")
    private int minCons;
    @Value("#{T(java.lang.Runtime).getRuntime().availableProcessors() * 2}")
    private int maxCons;

    /**
     * 注册数据源
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);

        System.out.println("minCons:" + minCons + "===maxCons:" + maxCons);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
