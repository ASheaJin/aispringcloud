package com.test.feign;

import com.test.entity.Student;
import com.test.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 声明式接口，只需要添加注解即可，不需要添加实现
 */
@FeignClient(value = "provider", fallback = FeignError.class) // 这里的值是服务提供者的名字,出现问题进行降级处理
public interface FeignProviderClient {
    @GetMapping("/student/findAll") // 这里跟provider中的请求接口一致，ribbon中还需要写resttemplate
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();

}
