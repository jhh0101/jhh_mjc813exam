package com.mjc813.spacrud_ex.genre.controller;

import com.mjc813.spacrud_ex.genre.dto.GenreDto;
import com.mjc813.spacrud_ex.genre.dto.GenreEntity;
import com.mjc813.spacrud_ex.genre.service.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {

    @Autowired
    private GenreRepository repository;

    @PostMapping("")
    public ResponseEntity<GenreEntity> insert(@RequestBody GenreEntity entity){
        try{
            this.repository.save(entity);
            return ResponseEntity.ok(entity);
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(entity);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<GenreEntity> update(@RequestBody GenreEntity entity){
        try{
            this.repository.save(entity);
            return ResponseEntity.ok(entity);
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(entity);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        try{
            this.repository.deleteById(id);
            return ResponseEntity.ok(id);
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> findById(@PathVariable Long id){
        try{
            Optional<GenreEntity> opt = this.repository.findById(id);
            if(opt.isPresent()){
                return ResponseEntity.ok(opt.orElse(null));
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(null);
        }
    }
}
