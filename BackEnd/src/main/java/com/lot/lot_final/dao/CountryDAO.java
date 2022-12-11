package com.lot.lot_final.dao;

import com.lot.lot_final.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDAO extends JpaRepository<Country,Integer> {

List<Country> findAll();

List<Country> findAllByCountryName(String countryName);
}
