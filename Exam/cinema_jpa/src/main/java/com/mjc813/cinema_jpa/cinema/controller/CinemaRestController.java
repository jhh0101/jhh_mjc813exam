package com.mjc813.cinema_jpa.cinema.controller;

import com.mjc813.cinema_jpa.cinema.dto.CinemaDto;
import com.mjc813.cinema_jpa.cinema.dto.CinemaEntity;
import com.mjc813.cinema_jpa.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_jpa.cinema.service.CinemaService;
import com.mjc813.cinema_jpa.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
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
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("insert error", 90000, null));
        }
    }

    @PostMapping("/genre")
    public ResponseEntity<ResponseDto> insertWithGenre(@RequestBody CinemaGenreDto cinemaGenreDto){
        try{
            this.cinemaService.insertWithGenre(cinemaGenreDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, cinemaGenreDto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("insertWithGenre error", 90000, null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable("id") Long id){
        try{
            CinemaEntity entity = this.cinemaService.findById(id);
            if(entity == null){
                return ResponseEntity.status(610).body(getResponseDto("Not Found", 88888, null));
            }
            return ResponseEntity.ok(getResponseDto("Success", 50010, entity));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("findById error", 90000, e));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> findByWhere(){
        try {
            List<CinemaGenreDto> list = this.cinemaService.findByWhere();
            return ResponseEntity.ok(getResponseDto("Success", 50010, list));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("findByWhere error", 90000, e));
        }
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> update(@RequestBody CinemaDto cinemaDto){
        try {
            this.cinemaService.update(cinemaDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, cinemaDto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("update error", 90000, e));
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestBody CinemaDto cinemaDto){
        try {
            this.cinemaService.delete(cinemaDto.getId());
            return ResponseEntity.ok(getResponseDto("Success", 50010, cinemaDto.getId()));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("delete error", 90000, e));
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
