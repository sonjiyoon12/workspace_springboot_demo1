package com.example.demo1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserDTO2 {
    private String name;
    private Integer age;
    @JsonProperty("car_list")
    private List<CarDTO> carList;


    // 내부 클래스
    @Getter
    @ToString
    static class CarDTO {
        private String name;
        @JsonProperty("car_number")
        private String carNumber;
    }
}
