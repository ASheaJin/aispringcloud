package com.test.feign.impl;

import com.test.entity.Student;
import com.test.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 如果出错就进入到实现类中
 */
@Component
public class FeignError implements FeignProviderClient {
    public Collection<Student> findAll() {
        return null;
    }

    public String index() {
        return "服务维护中。。。";
    }
}
