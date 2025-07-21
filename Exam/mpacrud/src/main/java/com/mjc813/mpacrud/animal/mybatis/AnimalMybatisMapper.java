package com.mjc813.mpacrud.animal.mybatis;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalMybatisMapper {
    void insert(AnimalDto animalDto);
}

