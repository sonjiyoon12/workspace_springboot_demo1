package com.example.demo1.dto;

import lombok.*;

import java.util.List;

/**
 * DTO 설계
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    // phone, website 생략
    private Company company;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
   static class Geo {
        private String lat;
        private String lng;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }
}

/*@Getter
@ToString
public class Users {
    private String id;
    private String name;
    private String username;
    private String email;
    private addressDTO address;
    private String phone;
    private String website;
    private companyDTO company;

    @Getter
    @ToString
    static class addressDTO {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private geoDTO geo;
    }

    @Getter
    @ToString
    static class geoDTO {
        private String lat;
        private String lng;
    }

    @Getter
    @ToString
    static class companyDTO {
        private String name;
        private String catchPhrase;
        private String bs;
    }
}*/
