package com.mjc813.swimpool_app.user.controller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> insert(){
        try {

        }catch (Throwable e){

        }
    }
}
