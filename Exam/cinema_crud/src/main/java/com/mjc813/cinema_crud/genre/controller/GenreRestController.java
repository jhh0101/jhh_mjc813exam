package com.mjc813.cinema_crud.genre.controller;

import com.mjc813.cinema_crud.common.ResponseDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import com.mjc813.cinema_crud.genre.service.GenreService;
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
        try{
            this.genreService.insert(genreDto);
            ResponseDto result = ResponseDto.builder()
                    .message("Success")
                    .resultCode(50010)
                    .resultData(genreDto)
                    .build();
            return ResponseEntity.ok(result);
        } catch (Throwable e) {
            ResponseDto result = ResponseDto.builder()
                    .message("Error")
                    .resultCode(90000)
                    .resultData(null)
                    .build();
            return ResponseEntity.status(500).body(result);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findGenre(){
        try {
            List<GenreDto> list = this.genreService.findGenre();
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
