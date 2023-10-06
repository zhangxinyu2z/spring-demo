# demo-mybatis

spring整合mybatis

演示了两种方式来使用mybatis
1. 注入sqlSessionFactory，获取到sqlSession，在sqlMapConfig中配置：<mapper resource="com/z2xinyu/mybatis/mapper/GoodsSpuMapper.
   xml"/>指定mapper.xml的位置。
2. 使用Mapper动态代理的方式：在sqlMapConfig中扫描包下的mapper.xml进行关联，配置MapperScannerConfigurer扫描mapper包下的mapper接口，生成实现类