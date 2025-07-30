package com.mjc813.swimpool.service;

import com.mjc813.swimpool.common.ResponseListDto;
import com.mjc813.swimpool.dto.SwimDto;
import com.mjc813.swimpool.dto.SwimSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwimMapper {

    public void insert(SwimDto swimDto);
    public List<SwimDto> selectList();
    public SwimDto selectOne(Long id);
    public void update(SwimDto swimDto);
    public void delete(Long id);
    public List<SwimDto> selectSearch(SwimSearchDto searchDto);
    public Integer totalCount(SwimDto swimDto);
}
