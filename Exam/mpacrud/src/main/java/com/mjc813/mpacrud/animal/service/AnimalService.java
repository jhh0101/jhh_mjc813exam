package com.mjc813.mpacrud.animal.service;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.mybatis.AnimalMybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalMybatisMapper animalMybatisMapper;

    public AnimalService(AnimalMybatisMapper animalMybatisMapper) {
        this.animalMybatisMapper = animalMybatisMapper;
    }

    public void insert(AnimalDto animalDto){
        animalMybatisMapper.insert(animalDto);
    }

    public List<AnimalDto> findAll(){
        return animalMybatisMapper.findAll();
    }

    public AnimalDto findById(Long id){
        return animalMybatisMapper.findById(id);
    }
}
