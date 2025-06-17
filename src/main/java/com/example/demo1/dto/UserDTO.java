package com.example.demo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDTO {
    private int id;
    private String name;
    private Integer age;
    private String phoneNumber;

    public static void main(String[] args) {

    }
}
