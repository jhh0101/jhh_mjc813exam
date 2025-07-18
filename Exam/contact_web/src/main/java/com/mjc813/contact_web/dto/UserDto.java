package com.mjc813.contact_web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String userId;
    private String password;
    private String userName;
    private String userEmail;
    private String role;
}
