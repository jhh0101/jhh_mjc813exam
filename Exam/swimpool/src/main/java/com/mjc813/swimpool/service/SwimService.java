package com.mjc813.swimpool.service;

import com.mjc813.swimpool.dto.SwimDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwimService {

    @Autowired
    private SwimMapper swimMapper;

    public void insert(SwimDto swimDto){
        swimMapper.insert(swimDto);
    }
    public List<SwimDto> selectList(){
        return swimMapper.selectList();
    }
    public SwimDto selectOne(Long id){
        return swimMapper.selectOne(id);
    }
    public void update(SwimDto swimDto){
        swimMapper.update(swimDto);
    }
    public void delete(Long id){
        swimMapper.delete(id);
    }
}