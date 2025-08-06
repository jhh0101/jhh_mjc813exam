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
        this.bandRepository.save(new BandEntity().getBandEntity(null, bandDto));
    }

    public List<BandEntity> findAll(){
        return this.bandRepository.findAll();
    }

    public Optional<BandEntity> findById(Long id){
        return this.bandRepository.findById(id);
    }

    public void update(Long id, BandDto bandDto){
        this.bandRepository.save(new BandEntity().getBandEntity(id, bandDto));
    }

    public void delete(Long id){
        this.bandRepository.deleteById(id);
    }


}
