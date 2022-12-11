package com.lot.lot_final.dao;

import com.lot.lot_final.entity.CountryLatest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryLatestDAO extends JpaRepository<CountryLatest,Integer> {
    @Override
    List<CountryLatest> findAll();

    CountryLatest findByCountryName(String countryName);
}
