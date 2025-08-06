package com.mjc813.band_jpa.service;

import com.mjc813.band_jpa.dto.BandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "api_band")
public interface BandRepository extends JpaRepository<BandEntity, Long> {
}
