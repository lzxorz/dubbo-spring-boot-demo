package org.lzx.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Reference(version = "1.0.0")
    private HelloWorldService helloWorldService;

    @Override
    public String testSayHello(String name) {
        return helloWorldService.sayHello(name);
    }
}