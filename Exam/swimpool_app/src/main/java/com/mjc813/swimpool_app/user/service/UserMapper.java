package com.mjc813.swimpool_app.user.service;

import com.mjc813.swimpool_app.security.dto.LoginDto;
import com.mjc813.swimpool_app.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface UserMapper{
    public void addUser(UserDto dto);
    public List<UserDto> findAll();
    public UserDto findById(Long id);
    public void updateUser(UserDto dto);
    public void deleteUser(Long id);
    UserDto findByUsername(LoginDto loginDto);
}
