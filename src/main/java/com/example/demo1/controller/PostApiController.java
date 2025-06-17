package com.example.demo1.controller;

import com.example.demo1.dto.UserDTO;
import com.example.demo1.dto.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // IoC 대상이 된다(프레임워크가 직접 객체 단 하나만 생성 한다)
@RequestMapping("/post") // 해당 컨트롤러 객체의 대문(공통 주소 사용)
public class PostApiController {

    /**
     * 주소 설계
     * POST 방식
     * http://localhost:8080/post/demo1
     * http body = {"name" : "둘리", "age" : 11}
     */
    @PostMapping("/demo1")
    public String demo1(@RequestBody Map<String, Object> reqData) {
        StringBuffer sb = new StringBuffer();
        reqData.entrySet().forEach(e ->{
            System.out.println("key : " + e.getKey() + " = " + e.getValue());
            sb.append(e.getKey() + " = " + e.getValue());
        });
        return sb.toString();
    }

    /**
     * 주소 설계
     * POST 방식
     * http://localhost:8080/post/demo2
     * http body = {"name" : "둘리", "age" : 11}
     * [Post 는 요청에 본문이 있다 - Object로 파싱해보기]
     * DTO -
     */
    @PostMapping("/demo2")
    // 스프링 프레임워크가 본문에서 값을 읽어서 UserDTO 객체를 생성한다.
    // public String demo2(@RequestBody UserDTO userDto) {
    public UserDTO demo2(@RequestBody UserDTO userDto) {

        System.out.println(userDto);
        System.out.println(userDto.getName());
        System.out.println(userDto.getAge());
        System.out.println(userDto.getPhoneNumber());

        return userDto;
    }

//    @PostMapping("/demo3")
//    public Users demo3(@RequestBody Users users) {
//        System.out.println(users);
//        System.out.println(users.getId());
//        System.out.println(users.getName());
//        System.out.println(users.getUsername());
//        System.out.println(users.getEmail());
//        System.out.println(users.getAddress());
//        System.out.println(users.getPhone());
//        System.out.println(users.getWebsite());
//        System.out.println(users.getCompany());
//
//        return users;
//    }

    @PostMapping("/demo3")
    public Users demo3(@RequestBody Users dto) {
        System.out.println(dto.toString());
        return dto;
    }
}
