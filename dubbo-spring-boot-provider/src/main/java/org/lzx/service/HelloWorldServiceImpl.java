package org.lzx.service;

import org.apache.dubbo.config.annotation.Service;



@Service(version = "1.0.0")
public class HelloWorldServiceImpl implements HelloWorldService {

    /**
     * 1.dubbo服务发布采用dubbo注解方式，使用 Dubbo 提供的 @Service 注解进行服务的发布
     * 2.Dubbo 提供@Service 将该接口注册到注册中心去 *
     * 3.Spring 提供@Service 将类注入到Spring容器中去
     */
    @Override
    public String sayHello(String name) {
        return "你好," + name;
    }
}
