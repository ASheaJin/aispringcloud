package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    // 这里就很方便的进行了注入，不用通过其他的
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
