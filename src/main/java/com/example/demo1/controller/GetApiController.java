package com.example.demo1.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * GET 방식 요청 주소 설계와 핸들러 처리를
 * 학습한다.
 */

// IoC 의 대상 -- 스프링 프레임워크가 자동으로 new 해줌
 @Controller //스프링 프레임워크 안에 --> 뷰 리졸브 --> 해당 경로에 파일을 찾는 일을 함
 // @RestController // 데이터를 반환 하는 일을 함
// @RestController // @Controller + @ResponseBody
public class GetApiController {

    // GET 방식으로 요청을 하면 처리하는 메서드를 만들어 두어야 한다.
    // 주소 설계: http://localhost:8080/hello
    @GetMapping("/hello")
    @ResponseBody // 파일 경로를 찾는게 아니라 그냥 데이터 반환 해
    public String hello() {
        //return "Say hello";
        // index.mustache <--파일 찾기
        return "index";
    }

    /**
     * 쿼리스트링 방식(@RequestParam)
     * 주소 설계
     * http://localhost:8080/qs1?name=둘리
     * @param name=value
     * @return String
     */
    @GetMapping("/qs1")
    public String qs1(@RequestParam(name = "name")String name) {
        return "응답받은 name키값의 값은 = " + name;
    }


    /**
     * 웹브라우저 주소창에 작성하는 주소 (Get 요청 방식)
     * 쿼리 스트링 방식
     * 주소 설계
     * http://localhost:8080/qs2?name=둘리&age=10
     * required = false, defaultValue = "고길동"
     */

    @GetMapping("/qs2")
    public String qs2(@RequestParam(name = "name") String name,
                      @RequestParam(name = "age", required = false, defaultValue = "0") int age) {
        System.out.println("name : " + name);
        System.out.println("age : " + age);

        return "name="+name+"&age="+age;
    }

    /**
     * 쿼리스트링 방식
     * 주소 설계
     * http://localhost:8080/qs3?name=둘리&age=10&groupId=com.tenco
     * @param name, age, groupId
     * @retuen String
     */

    @GetMapping("/qs3")
    public String qs3(@RequestParam(name = "name") String name,
                      @RequestParam(name = "age") int age, //Integer 가능
                      @RequestParam(name = "groupId") String groupId){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("groupId : " + groupId);
        return "name="+name+"age="+age+"groupId="+groupId;
    }


    //주소 설계
    // http://localhost:8080/qs4
    @GetMapping("/qs4")
    @ResponseBody
    public User helloObject() {
        //응답시에 데이터를 반환 단 (User Object로 내려 보자)
        // Object (서버 측) 응답시킬 때 -- 잭슨, Gson
        // new User("마이콜",20); --> 문자열로 변환 시키기 위해서
        // 반드시 @Getter 가 있어야 한다.
        return new User("마이콜",20);
    }

    // 내부 클래스
    @AllArgsConstructor
    @Getter
    class User {
        private String name;
        private Integer age;
    }

    //http://localhost:8080/qs5?a=둘리&b=10&c=com.tenco
    @GetMapping("/qs5")
    @ResponseBody
    public String qs5(@RequestParam Map<String,String> data) {
        // Map 방식으로 동적으로 들어오는 키와값을 받아서 처리해 보자.
        // StringBuilder 단일 스레드에서 문자열 만들 때
        // StringBuffer 멀티 스레드에서 문자열 만들 때
        StringBuffer sb = new StringBuffer();
        data.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            sb.append(entry.getKey()+"="+entry.getValue()+"\n");
        });

        return sb.toString();
    }
    
}
