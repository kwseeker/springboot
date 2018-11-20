# Spring AOP

### 一、AOP 使用场景

+ Authentication 权限 
+ Caching 缓存 
+ Context passing 内容传递 
+ Error handling 错误处理 
+ Lazy loading　懒加载 
+ Debugging　调试 
+ logging, tracing, profiling and monitoring　记录跟踪,优化,校准 
+ Performance optimization　性能优化 
+ Persistence 持久化 
+ Resource pooling　资源池 
+ Synchronization　同步 
+ Transactions 事务 


### 二、AOP的优点

### 三、SpringBoot集成AOP
1) 引入依赖  
    ```$xslt
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
    ```
2) 配置
    ```$xslt
    spring:
      aop:
        auto: true                # Add @EnableAspectJAutoProxy
        proxy-target-class: true  # 为true则是基于类的代理将起作用（需要cglib库），为false或者省略这个属性，则标准的JDK基于接口的代理将起作用。
    ```
3) 定义切面类
    

### 四、AOP使用实例
+ 权限控制
+ 日志

### 五、AOP实现原理

+ JointPoint原理
