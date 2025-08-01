package com.mjc813.cinema_jpa.cinema.service;

import com.mjc813.cinema_jpa.cinema.dto.CinemaDto;
import com.mjc813.cinema_jpa.cinema.dto.CinemaGenreDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    public void insert(CinemaDto cinemaDto){
//        this.cinemaMapper.insert(cinemaDto);
    }
    public void insertWithGenre(CinemaGenreDto cinemaGenreDto){
//        GenreDto genreDto = new GenreDto();
//        genreDto.setName(cinemaGenreDto.getGenre());
//
//        CinemaDto cinemaDto = new CinemaDto();
//        cinemaDto.setName(cinemaGenreDto.getName());
//        cinemaDto.setCasts(cinemaGenreDto.getCasts());
//        cinemaDto.setPlayTime(cinemaGenreDto.getPlayTime());
//        cinemaDto.setDescription(cinemaGenreDto.getDescription());
//        cinemaDto.setRestrictAge(cinemaGenreDto.getRestrictAge());
//
//        this.genreMapper.insert(genreDto);
//        cinemaDto.setGenreId(genreDto.getId());
//
//        this.cinemaMapper.insert(cinemaDto);
//        cinemaGenreDto.setId(cinemaDto.getId());
    }
    public CinemaDto findById(Long id){
//        return this.cinemaMapper.findById(id);
        return null;
    }
    public List<CinemaGenreDto> findByWhere(){
//        return this.cinemaMapper.findByWhere();
        return null;
    }
    public void update(CinemaDto cinemaDto){
//        this.cinemaMapper.update(cinemaDto);
    }
    public void delete(Long id){
//        this.cinemaMapper.delete(id);
    }
}
