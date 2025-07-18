package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.ContactDto;
import com.mjc813.contact_web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMybatisMapper {
    void singUp(UserDto user);
}
