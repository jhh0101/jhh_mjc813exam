package com.mjc813.band_jpa.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BandEntity")
@Table(name="band_tbl")
@Builder
public class BandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String leader;
    private String guitarFirst;
    private String guitarSecond;
    private String drum;
    private String bass;
    private String keyboard;
    private String vocal;

    public BandEntity getBandEntity(Long id, BandDto bandDto){
        return BandEntity.builder()
                .id(id)
                .name(bandDto.getName())
                .leader(bandDto.getLeader())
                .guitarFirst(bandDto.getGuitarFirst())
                .guitarSecond(bandDto.getGuitarSecond())
                .drum(bandDto.getDrum())
                .bass(bandDto.getBass())
                .keyboard(bandDto.getKeyboard())
                .vocal(bandDto.getVocal())
                .build();
    }

}
