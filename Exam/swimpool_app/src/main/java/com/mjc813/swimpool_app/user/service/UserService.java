package com.mjc813.swimpool_app.user.service;

import com.mjc813.swimpool_app.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public void addUser(UserDto dto){
        mapper.addUser(dto);
    }
    public List<UserDto> findAll(){
        return mapper.findAll();
    }
    public UserDto findById(Long id){
        return mapper.findById(id);
    }
    public void updateUser(UserDto dto){
        mapper.updateUser(dto);
    }
    public void deleteUser(Long id){
        mapper.deleteUser(id);
    }
}
