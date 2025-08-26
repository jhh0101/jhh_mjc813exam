package com.mjc813.spacrud_ex.song.controller;


import com.mjc813.spacrud_ex.common.ResponseDto;
import com.mjc813.spacrud_ex.song.dto.SongEntity;
import com.mjc813.spacrud_ex.song.service.SongRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/song")
public class SongRestController {
    @Autowired
    private SongRepository repository;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody SongEntity entity){
        try {
            this.repository.save(entity);
            return ResponseEntity.ok(ResponseDto.builder()
                            .resultCode(111)
                            .message("Success")
                            .resultData(entity)
                            .build());
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("Error")
                    .resultData(entity)
                    .build());
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try {
            List<SongEntity> all = this.repository.findAll();
            return ResponseEntity.ok(ResponseDto.builder()
                    .resultCode(111)
                    .message("Success")
                    .resultData(all)
                    .build());
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("Error")
                    .resultData(null)
                    .build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id){
        try {
            Optional<SongEntity> entity = this.repository.findById(id);
            return ResponseEntity.ok(ResponseDto.builder()
                    .resultCode(111)
                    .message("Success")
                    .resultData(entity)
                    .build());
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("Error")
                    .resultData(null)
                    .build());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findByTitleAndArtist(@RequestParam("title") String title
            , @RequestParam("artist") String artist
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        try{
            Page<SongEntity> page = this.repository.findByTitleOrArtistContains(title,artist,pageable);
            return ResponseEntity.ok(ResponseDto.builder()
                            .resultCode(111)
                            .message("Success")
                            .resultData(page)
                            .build());
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                            .resultCode(999)
                            .message("Error")
                            .resultData(null)
                            .build());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@RequestBody SongEntity entity){
        try {
            this.repository.save(entity);
            return ResponseEntity.ok(ResponseDto.builder()
                    .resultCode(111)
                    .message("Success")
                    .resultData(entity)
                    .build());
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("Error")
                    .resultData(entity)
                    .build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id){
        try {
            this.repository.deleteById(id);
            return ResponseEntity.ok(ResponseDto.builder()
                    .resultCode(111)
                    .message("Success")
                    .resultData(id)
                    .build());
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("Error")
                    .resultData(id)
                    .build());
        }
    }
}
