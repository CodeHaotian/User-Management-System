# User-Management-System

## 需求

- 对用户信息进行增删改查

## 技术选型

### 后端技术

- Java：JDK9
- [Servlet：4.0.1](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api)
- [Spring jdbc：5.1.5](https://mvnrepository.com/artifact/org.springframework/spring-jdbc)
- [Druid：1.1.11](https://mvnrepository.com/artifact/com.alibaba/druid)
- [BeanUtUtils：1.9.3](https://mvnrepository.com/artifact/commons-beanutils/commons-beanutils)

### 前端技术

- [Bootstrap：3.3.7](https://v3.bootcss.com/)

### 管理工具

- Maven：3.6.0

### 数据库

- MySQL：5.7.25

### 运行容器

- Tomcat：9.0.7

## 编码

### 创建数据库

 ```sql
CREATE TABLE USER (  --  创建用户表
 
 	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 
 	NAME VARCHAR(20) NOT NULL,
 
 	sex ENUM('男','女') DEFAULT '男',
  
	age INT(11),
  
	address VARCHAR(32),
	
	qq VARCHAR(20) ,
	
	email VARCHAR(50) 
 );
```



