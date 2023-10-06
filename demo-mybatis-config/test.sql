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


create table orders
(
    id         int auto_increment
        primary key ,
    user_id    int          not null comment '下单用户id' ,
    number     varchar(32)  not null comment '订单号' ,
    createtime datetime     not null comment '创建订单时间' ,
    note       varchar(100) null comment '备注'
);