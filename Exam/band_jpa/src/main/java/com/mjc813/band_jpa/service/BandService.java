package com.mjc813.band_jpa.service;

import com.mjc813.band_jpa.dto.BandDto;
import com.mjc813.band_jpa.dto.BandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public void insert(BandDto bandDto){
        this.bandRepository.save(getBandEntity(null, bandDto));
    }

    public List<BandEntity> findAll(){
        return this.bandRepository.findAll();
    }

    public Optional<BandEntity> findById(Long id){
        return this.bandRepository.findById(id);
    }

    public void update(Long id, BandDto bandDto){
        this.bandRepository.save(getBandEntity(id, bandDto));
    }

    public void delete(Long id){
        this.bandRepository.deleteById(id);
    }

    private BandEntity getBandEntity(Long id, BandDto bandDto){
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
