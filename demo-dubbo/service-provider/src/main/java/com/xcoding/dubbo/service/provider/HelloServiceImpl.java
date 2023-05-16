package com.xcoding.dubbo.service.provider;

import com.xcoding.dubbo.common.service.HelloService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxinyu
 * @date 2023/5/16
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +
            ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
