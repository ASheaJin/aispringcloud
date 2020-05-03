package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @SpringBootApplication： 声明该类是Spring Boot服务的入口
 *
 * @EnableEurekaServer： 声明该类是一个Eureka Server微服务，提供服务注册和服务发现的功能，即注册中心
 *
 * 启动后访问  http://localhost:8761/
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekServerApplication.class, args);
    }
}
