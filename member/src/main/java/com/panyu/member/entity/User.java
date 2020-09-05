package com.panyu.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String userName;

    private String name;

    private Integer age;

    private String balance;

    private  String password;

}
