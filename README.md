# dubbo-spring-boot-demo
springboot2.1.8、dubbo2.7.3、nacos1.13 demo

**nacos 安装、启动**

1. [Github releases下载nacos压缩包](https://github.com/alibaba/nacos/releases)，然后解压
2. 启动服务器
	以单机模式为例, 其他模式可参考： [Nacos的三种部署模式](https://www.jianshu.com/p/8a0df112d03d)
	- Linux/Unix/Mac 启动命令(standalone代表着单机模式运行，非集群模式):
		```shell
		# Linux/Unix/Mac 系统下启动
		sh startup.sh -m standalone
		# Ubuntu/Deepin (Debian分支的Linux系统)系统下启动
		bash -f bin/startup.sh -m standalone
		```
	
	- Windows 启动命令：
 	`cmd startup.cmd 或者 双击startup.cmd`

3. 启动成功
[浏览器访问 http://localhost:8848/nacos/index.html](http://localhost:8848/nacos/index.html) ，`用户`和`密码`都是 `nacos`

4. 关闭服务器
	- Linux/Unix/Mac
 	`sh shutdown.sh 或者 bash -f bin/shutdown.sh`
	- Windows
	`cmd shutdown.cmd 或者 双击shutdown.cmd`

**spring-boot、dubbo 项目中使用**

官方文档：[Nacos Spring Boot 快速开始](https://nacos.io/zh-cn/docs/quick-start-spring-boot.html)

父工程pom部分内容
```xml
<!--Dubbo-->
	<!-- 编写统一的版本控制 -->
    <properties>
        <spring-boot-version>2.1.8.RELEASE</spring-boot-version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <java-version>1.8</java-version>
        <dubbo-spring.version>2.7.3</dubbo-spring.version>
        <nacos.version>1.1.3</nacos.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>${dubbo-spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo</artifactId>
            <version>${dubbo-spring.version}</version>
        </dependency>

        <!--nacos-->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-registry-nacos</artifactId>
            <version>${dubbo-spring.version}</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-client</artifactId>
            <version>${nacos.version}</version>
        </dependency>
 	</dependencies>
```

服务提供者 application.yml
nacos配置中心 nacos.config.server-addr
dubbo注册中心 dubbo.registry.address

```yml
# nacos配置中心
nacos:
  config:
    server-addr: localhost:8848

# Base packages to scan Dubbo Component: @org.apache.dubbo.config.annotation.Service
## Dubbo 服务提供者配置
dubbo:
  # Dubbo应用 注册到注册中心的名称，的默认值是$ {spring.application.name}
  application:
    name: provider
  scan:
    # Dubbo组件扫描的基础包
    base-packages: org.lzx.service
  # Dubbo 协议与端口
  protocol:
    name: dubbo
    port: 20880
  ## Dubbo Registry
  registry:
    # 注册中心地址
    #address: zookeeper://localhost:2181 #zookeeper
    address: nacos://localhost:8848
```

服务消费者 application.yml
```yml
#dubbo 消费者配置
dubbo:
  # Dubbo应用 注册到注册中心的名称，的默认值是$ {spring.application.name}
  application:
    name: consumer
  registry:
    # 注册中心地址
    #address: zookeeper://localhost:2181 #zookeeper
    address: nacos://localhost:8848
```

先启动服务提供者 `DubboSpringBootProviderApplication`

然后启动服务消费者 `DubboSpringBootConsumerApplication`

<<<<<<< HEAD
浏览器访问消费者测试 [http://localhost:10087/consumer/hello/o(∩_∩)o](http://localhost:10087/consumer/hello/o(∩_∩)o)

=======
>>>>>>> a2d9755626197af4e93d0364d792040d6621de47
浏览器页面显示`你好,o(∩_∩)o`
