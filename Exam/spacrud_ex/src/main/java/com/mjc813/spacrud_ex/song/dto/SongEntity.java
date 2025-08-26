package com.mjc813.spacrud_ex.song.dto;

import com.mjc813.spacrud_ex.genre.dto.GenreEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="song_tb")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    @Column(nullable = false, length = 50)
    private String composer;

    @Column(nullable = false, length = 50)
    private String artist;

    @Column(nullable = false)
    private LocalDate releaseDate;

}
