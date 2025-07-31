package com.mjc813.cinema_crud.genre.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {
    public void insert(GenreDto genreDto);
    public List<GenreDto> findGenre();
    public void update(GenreDto genreDto);
    public void delete(Long id);
}
