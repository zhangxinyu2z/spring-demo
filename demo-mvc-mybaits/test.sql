-- auto-generated definition
create table user
(
    ID       int auto_increment
        primary key ,
    username varchar(20)  null ,
    sex      varchar(2)   null ,
    birthday date         null ,
    address  varchar(100) null ,
    constraint user_ID_uindex
        unique ( ID )
)
    comment 'mybatis测试表';



DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(32) NOT NULL COMMENT '商品名称',
                         `price` float(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `createtime` datetime NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;