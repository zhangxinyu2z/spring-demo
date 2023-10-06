# demo-mybatis-config

mybatis的配置和使用方式demo

有哪些案例：
1. 延迟加载
   1. 通常1对多、多对多采用延迟加载，1对1、多对1采用立即加载
   2. 可以设置局部的加载策略，优先级高于全局，collection设置属性： fetchType="lazy" 懒加载策略  "eager" ⽴即加载策略
2. $和#的演示
3. @Select等注解使用动态sql
4. mapper.xml标签的使用
5. 自定义日志的方式：因为日志不打印sql语句 [mybatis3配置](https://mybatis.org/mybatis-3/zh/configuration.html#properties)
6. mapper.update() 返回的是匹配的记录数，而不是影响的行数即修改的行数（如果想，可以在url上加useAffectedRows=true试试）
7. 动态传参数值为0时，条件无效：mybatis对于数值型的参数，如果为0，会当成''
   1. 去掉空串的判断
   2. 不传数值，传字符串，比如 "0"