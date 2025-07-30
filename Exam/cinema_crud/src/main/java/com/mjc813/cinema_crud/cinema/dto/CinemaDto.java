package com.mjc813.cinema_crud.cinema.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {
    private Long id;
    private String name;
    private String genreId;
    private String playTime;
    private String casts;
    private String description;
    private Integer restrictAge;
}
