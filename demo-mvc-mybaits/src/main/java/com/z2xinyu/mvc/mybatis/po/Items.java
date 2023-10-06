package com.z2xinyu.mvc.mybatis.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Items {
    private Integer id;

    private String name;

    private Float price;

    private String pic;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理前端传参的string日期格式化，作用类似于converter, 请求非json数据
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") // 数据库查询的日期结果，相应的json格式数据为时间戳 配合@requestBody修改日期格式
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}