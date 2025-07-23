package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.ContactDto;
import com.mjc813.contact_web.dto.PagingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRepository {

    private final IContactMybatisMapper iContactMapper;

    @Autowired
    public ContactRepository(IContactMybatisMapper iContactMapper) {
        this.iContactMapper = iContactMapper;
    }

    public void insert(ContactDto contact){
        iContactMapper.insert(contact);
    }

    public List<ContactDto> selectAll(PagingDto pagingDto){
        return iContactMapper.selectAll(pagingDto);
    }

    public ContactDto select(Integer id){
        return iContactMapper.select(id);
    }

    public void update(ContactDto contact){
        iContactMapper.update(contact);
    }

    public void delete(Integer id){
        iContactMapper.delete(id);
    }
}
