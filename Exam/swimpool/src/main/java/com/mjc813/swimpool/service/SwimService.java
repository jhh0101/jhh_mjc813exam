package com.mjc813.swimpool.service;

import com.mjc813.swimpool.common.ResponseListDto;
import com.mjc813.swimpool.dto.SwimDto;
import com.mjc813.swimpool.dto.SwimSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwimService {

    private final SwimMapper swimMapper;

    public void insert(SwimDto swimDto){
        swimMapper.insert(swimDto);
    }
    public List<SwimDto> selectList(){
        return swimMapper.selectList();
    }
    public SwimDto selectOne(Long id){
        return swimMapper.selectOne(id);
    }
    public SwimDto update(SwimDto swimDto){
        swimMapper.update(swimDto);
        return swimDto;
    }
    public void delete(Long id){
        swimMapper.delete(id);
    }
    public List<SwimDto> selectSearch(SwimSearchDto searchDto){
        return swimMapper.selectSearch(searchDto);
    }
    public Integer totalCount(SwimDto swimDto){
        return swimMapper.totalCount(swimDto);
    }
}