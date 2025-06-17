package com.example.demo1.controller;

import com.example.demo1.dto.UserDTO;
import com.example.demo1.dto.UserDTO2;
import org.springframework.web.bind.annotation.*;

@RestController // IoC 대상이 된다.
@RequestMapping("/put")
public class PutApiController {
    /**
     * 주소 설계
     * METHOD - PUT
     * http://localhost:8080/put/demo1
     */

    @PutMapping("/demo1")
    public UserDTO2 put1(@RequestBody UserDTO2 userDTO2) {
        System.out.println(userDTO2.toString());
        //리턴 타입 Object 내려 주고 있다 -->
        // MappingJackson2HttpMessageConverter 객체가 문자열(json) 반환해서 던진다.
        return userDTO2;
    }

    // 주소 설계
    // http://localhost:8080/put/user/1
    @PutMapping("/user/{id}")
    public UserDTO put2(@PathVariable(name = "id") Integer userId, @RequestBody UserDTO dto) {
        System.out.println("userId : " + userId);
        System.out.println("userDTO : " + dto);
        return dto;
    }

}
