package com.test.controller;


import com.test.entity.Student;
import com.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController //在Spring中@RestController的作用等同于@Controller + @ResponseBody。
@RequestMapping("/student")
public class StudentHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    /**
     * 这里传入的是json字符串，用RequestBody进行映射
     * @param s
     */
    @PostMapping("/save")
    public void save(@RequestBody Student s) {
        studentRepository.saveOrUpdate(s);
    }

    @PutMapping("/update")
    public void Update(@RequestBody Student s) {
        studentRepository.saveOrUpdate(s);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前端⼝："+this.port;
    }

}
