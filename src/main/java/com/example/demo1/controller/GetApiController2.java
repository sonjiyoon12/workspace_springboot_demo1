package com.example.demo1.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 직접 설계해보기
 */
@RestController
public class GetApiController2 {

    // http://localhost:8080/say
    @GetMapping("/say")
    public String say() {
        return "say yes";
    }

    // http://localhost:8080/rq1?id=abc&pwd=abcd124324
    @GetMapping("/rq1")
    public String rq1(@RequestParam (name = "id") String id,
                      @RequestParam(name = "pwd") String pwd) {

        return "id=" + id + "pwd=" + pwd;
    }

    // http://localhost:8080/rs2
    @GetMapping("/rs2")
    public User UserObject() {
        return new User("아무개",34);
    }


    @AllArgsConstructor
    @Getter
    class User {
        private String name;
        private Integer age;
    }
}
