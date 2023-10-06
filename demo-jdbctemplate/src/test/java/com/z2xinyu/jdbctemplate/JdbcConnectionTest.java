package com.z2xinyu.jdbctemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
public class JdbcConnectionTest {

    private static final String url = "jdbc:mysql://10.21.64.12:3306/meorientb2b_register_test?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";

    //    static {
    //        ResourceBundle bundle = ResourceBundle.getBundle("jdbc.properties");
    //        String driver = bundle.getString("jdbc.driver");
    //    }

    @Test
    public void testConnectionMySQL() throws Exception {
        Class.forName(driverClass);
        Connection c = DriverManager.getConnection(url, username, password);
        Assert.assertNotNull(c);
    }

    @Test
    public void testC3p0() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection c = dataSource.getConnection();
        Assert.assertNotNull(c);
    }
}
