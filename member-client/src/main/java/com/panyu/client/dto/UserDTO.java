package com.panyu.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

        private String id;

        private String userName;

        private String name;

        private Integer age;

        private String balance;

    }

