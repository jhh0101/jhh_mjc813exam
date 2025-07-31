package com.mjc813.cinema_crud.cinema.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CinemaMapper {
    public void insert(CinemaDto cinemaDto);
    public CinemaDto findById(Long id);
    public List<CinemaGenreDto> findByWhere();
    public void update(CinemaDto cinemaDto);
    public void delete(Long id);
}