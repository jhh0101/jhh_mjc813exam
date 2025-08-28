package com.mjc813.swimpool_app.user.service;

import com.mjc813.swimpool_app.security.dto.LoginDto;
import com.mjc813.swimpool_app.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    public void addUser(UserDto dto){
        dto.setPassword(this.encoder.encode(dto.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName(username);
        UserDto find = this.mapper.findByUsername(loginDto);
        return find;
    }
}
