package org.lzx;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo // 开启Dubbo
@SpringBootApplication
public class DubboSpringBootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringBootProviderApplication.class);
    }
}
