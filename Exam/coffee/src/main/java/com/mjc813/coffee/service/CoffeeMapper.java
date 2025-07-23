package com.mjc813.coffee.service;

import com.mjc813.coffee.dto.CoffeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoffeeMapper {
    public void insert(CoffeeDto coffeeDto);
    public List<CoffeeDto> selectAll();
    public CoffeeDto selectById(Long id);
    public void update(CoffeeDto coffeeDto);
    public void delete(Long id);
}
