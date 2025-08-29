package com.mjc813.swimpool_app.security.service;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.security.dto.LoginDto;
import com.mjc813.swimpool_app.user.dto.UserDto;
import com.mjc813.swimpool_app.user.service.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseDto login(LoginDto loginDto) {
        if ( loginDto == null ) {
            return ResponseDto.builder().code(ResponseEnum.AuthenticationFail.getCode()).responseEnum(ResponseEnum.AuthenticationFail).build();
        }
        UserDto find = this.userMapper.findByUsername(loginDto);
        if ( find == null ) {
            return ResponseDto.builder().code(ResponseEnum.AuthenticationFail.getCode()).responseEnum(ResponseEnum.AuthenticationFail).build();
        }
        if ( !passwordEncoder.matches(loginDto.getPassword(), find.getPassword()) ) {
//            if ( !loginDto.getPassword().equals(find.getPassword()) ) {
//                return ResponseDto.builder().code(ResponseEnum.AuthenticationFail.getCode()).responseEnum(ResponseEnum.AuthenticationFail).build();
//            }
            return ResponseDto.builder().code(ResponseEnum.AuthenticationFail.getCode()).responseEnum(ResponseEnum.AuthenticationFail).build();
        }
        return ResponseDto.builder().code(ResponseEnum.Success.getCode()).responseEnum(ResponseEnum.Success).data(find).build();
    }

    public Boolean changePassword(Long id, String password) {
        this.userMapper.update(UserDto.builder().id(id).password(this.passwordEncoder.encode(password)).build());
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(username);
        UserDto find = this.userMapper.findByUsername(loginDto);
        return find;
    }
}
