package com.mjc813.coffee.service;

import com.mjc813.coffee.dto.CoffeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    CoffeeMapper coffeeMapper;

    public void insert(CoffeeDto coffeeDto){
        coffeeMapper.insert(coffeeDto);
    }

    public List<CoffeeDto> selectAll(){
        return coffeeMapper.selectAll();
    }

    public CoffeeDto selectById(Long id){
        return coffeeMapper.selectById(id);
    }

    public void update(CoffeeDto coffeeDto){
        coffeeMapper.update(coffeeDto);
    }

    public void delete(Long id){
        coffeeMapper.delete(id);
    }
}
