package com.mjc813.cinema_jpa.cinema.service;

import com.mjc813.cinema_jpa.cinema.dto.CinemaDto;
import com.mjc813.cinema_jpa.cinema.dto.CinemaEntity;
import com.mjc813.cinema_jpa.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public void insert(CinemaDto cinemaDto){
        GenreEntity genre = new GenreEntity();
        genre.setId(cinemaDto.getGenreId());

        CinemaEntity cinema = new CinemaEntity();
        cinema.setGenre(genre);
        cinema.copyMembers(cinemaDto);
        this.cinemaRepository.save(cinema);
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
    public CinemaEntity findById(Long id){
        Optional<CinemaEntity> find = this.cinemaRepository.findById(id);
        return find.orElse(null);
    }
    public List<CinemaGenreDto> findByWhere(){
//        return this.cinemaMapper.findByWhere();
        return null;
    }
    public void update(CinemaDto cinemaDto){
        GenreEntity genre = new GenreEntity();
        genre.setId(cinemaDto.getGenreId());

        CinemaEntity cinema = new CinemaEntity();
        cinema.setGenre(genre);
        cinema.copyMembers(cinemaDto);
        this.cinemaRepository.save(cinema);
    }
    public void delete(Long id){
        this.cinemaRepository.deleteById(id);
    }

}
