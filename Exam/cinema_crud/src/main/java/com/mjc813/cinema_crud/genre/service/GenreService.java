package com.mjc813.cinema_crud.genre.service;

import com.mjc813.cinema_crud.genre.dto.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreMapper genreMapper;

    public void insert(GenreDto genreDto){
        this.genreMapper.insert(genreDto);
    }
    public List<GenreDto> findGenre(){
        return this.genreMapper.findGenre();
    }
    public void update(GenreDto genreDto){
        this.genreMapper.update(genreDto);
    }
    public void delete(Long id){
        this.genreMapper.delete(id);
    }
}
