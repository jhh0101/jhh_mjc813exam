package com.mjc813.cinema_jpa.genre.controller;

import com.mjc813.cinema_jpa.common.ResponseDto;
import com.mjc813.cinema_jpa.genre.dto.GenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import com.mjc813.cinema_jpa.genre.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {

    @Autowired
    private GenreService genreService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody GenreDto genreDto){
        try {
            GenreEntity entity = new GenreEntity(null, genreDto.getName());
            this.genreService.insert(genreDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, entity));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, e));
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findGenre(){
        try {
            List<GenreEntity> list = this.genreService.findGenre();
            return ResponseEntity.ok(getResponseDto("Success", 50010, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, e));
        }
    }

    @PatchMapping("")
    public ResponseEntity<ResponseDto> update(@RequestBody GenreDto genreDto){
        try {
            this.genreService.update(genreDto);
            return ResponseEntity.ok(getResponseDto("Success", 50010, genreDto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, e));
        }
    }

    @DeleteMapping("")
    public ResponseEntity<ResponseDto> delete(@RequestBody GenreDto genreDto){
        try {
            this.genreService.delete(genreDto.getId());
            return ResponseEntity.ok(getResponseDto("Success", 50010, genreDto.getId()));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(getResponseDto("Error", 90000, e));
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
