## Validator 后端参数校验

**目录**  
[1. 简介](#1)  
[1.1 ](#1.1)  
[1.2 ](#1.2)  
[2. 正则表达式](#2)

### 1. 简介
Spring Boot 常用的两种参数校验工具是 Spring-validator 和 Hibernate-validator。  
 
spring-boot-starter-web 依赖 hibernate-validator jackson-databind 包，
所以Spring Boot web应用默认支持hibernate validator进行校验。  

Hibernate Validator 是 Bean Validation 的参考实现 . Hibernate Validator 提供了 JSR 303 规范中所有内置 constraint 的实现，除此之外还有一些附加的 constraint。

#### 1.1 Hibernate validator 工作原理
+ Hibernate Validator 校验时间

### 2. java应用中使用 Hibernate Validator

### 3. Spring boot 集成 Hibernate Validator

##### 3.1 分组校验
使用到的校验注解都是有一个默认分组的 Default.class, 校验时不指定分组就是默认校验 Default.class 分组。

##### 3.2 组继承

##### 3.3 @GroupSequence 定义组序列与重新定义组序列
```$xslt
// Default.class -> CarChecks.class -> DriverChecks.class -> OrderdChecks 依次校验
@GroupSequence({ Default.class, CarChecks.class, DriverChecks.class })
public interface OrderedChecks {}
```

##### 3.4 DefaultGroupSequenceProvider @GroupSequenceProvider 动态地重新定义组序列 

##### 3.5 自定义校验
1）自定义校验注解  
2）编写校验者类  

##### 3.6 手动校验（使用 ValidatorFactory 构造校验器校验）
关于构造校验器参考：
org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration.java

之前碰到一个问题，前端传参要经过AOP解析到一个对象中，这个对象才是真正送到controller中的实参；
而经过调试发现 Hibernate Validator @Validated 注解在AOP之前就已经对参数进行了校验，
而不是对经过AOP解析之后真正传到controller方法的参数进行校验，这时就需要手动校验了。

使用手动校验可以随时随处进行校验。

##### 3.7 方法校验 

### 4. 正则表达式

### 5. 细节补充

+ Hibernate Validator 的三个非空注解 @NotNull @NotEmpty @NotBlank 的区别  
    ```$xslt
    @NotNull   适用于所有对象，不允许对象为null，用于8种基本数据类型是无效的
    @NotEmpty  适用于String, collection, map or array，不允许是null而且不允许为empty（即长度不能为0）
    @NotBlank   适用于String，不允许是null而且不允许为empty（即长度不能为0)
    
    @NotBlank 和 @NotEmpty 的区别是 @NotBlank 会忽略末尾的空白字符
    @NotBlank 和 @NotEmpty 都包含了 @NotNull注解
    ```
    
