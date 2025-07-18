package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {


    private final IUserMybatisMapper iUserMybatisMapper;

    @Autowired
    public UserRepository(IUserMybatisMapper iUserMybatisMapper) {
        this.iUserMybatisMapper = iUserMybatisMapper;
    }

    void signUp(UserDto user){
        iUserMybatisMapper.singUp(user);
    }
}
