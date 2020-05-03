package com.test.controller;

import com.shebao.framelib.util.bean.ReturnData;
import com.test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/rest")
public class RestHanlder {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        Map<String, String> map = new HashMap<>();
        map.put("companyId", "2029418");
        map.put("serviceType", "1");
        String body = "";
        try {
            ResponseEntity<ReturnData> returnData = restTemplate.postForEntity(
                    "http://127.0.0.1:8889/DBController/getCompanyInfoByCompanyId",
                    map, ReturnData.class
            );

            HttpStatus statusCode = returnData.getStatusCode();
            if (statusCode.is2xxSuccessful()) {
                body = "success!" + statusCode.value();
                System.out.println("success!" + statusCode.value());
                System.out.println(Objects.requireNonNull(returnData.getBody()).getRetCode());
            }
        } catch (Exception e) {
            body = "zuo wu";
        }

        return body;
    }

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }
    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8010/student/findById/{id}", Student.class,id).getBody();
    }
    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}", Student.class,id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/student/save",student,null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }
}
