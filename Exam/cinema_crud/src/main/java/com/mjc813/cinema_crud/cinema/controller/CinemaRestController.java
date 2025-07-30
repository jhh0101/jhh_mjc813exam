package com.mjc813.cinema_crud.cinema.controller;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_crud.cinema.service.CinemaService;
import com.mjc813.cinema_crud.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaRestController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody CinemaDto cinemaDto){
        try{
            this.cinemaService.insert(cinemaDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, cinemaDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, null));
        }
    }

    @PostMapping("/genre")
    public ResponseEntity<ResponseDto> insertWithGenre(@RequestBody CinemaGenreDto cinemaGenreDto){
        try{
            this.cinemaService.insertWithGenre(cinemaGenreDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, cinemaGenreDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, null));
        }
    }

    private ResponseDto getResponseDto(String msg, Integer code, Object data){
        return ResponseDto.builder()
                .message(msg)
                .resultCode(code)
                .resultData(data)
                .build();
    }

}
