package com.mjc813.cinema_crud.genre.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenreMapper {
    public void insert(GenreDto genreDto);

}
