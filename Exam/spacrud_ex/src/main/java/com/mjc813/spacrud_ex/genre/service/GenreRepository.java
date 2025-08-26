package com.mjc813.spacrud_ex.genre.service;

import com.mjc813.spacrud_ex.genre.dto.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
