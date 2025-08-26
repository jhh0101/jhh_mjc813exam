package com.mjc813.swimpool_app.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    private Integer maxLock;
}
