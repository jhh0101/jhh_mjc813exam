package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.ContactDto;
import com.mjc813.contact_web.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IContactMybatisMapper {
    void insert(ContactDto contact);
    List<ContactDto> selectAll(PagingDto pagingDto);
    ContactDto select(Integer id);
    void update(ContactDto contact);
    void delete(Integer id);

}
