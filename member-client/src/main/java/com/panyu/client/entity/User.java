package com.panyu.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
