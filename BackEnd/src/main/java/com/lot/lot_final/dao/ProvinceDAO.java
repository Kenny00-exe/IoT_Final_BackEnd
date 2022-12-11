package com.lot.lot_final.dao;

import com.lot.lot_final.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceDAO extends JpaRepository<Province,Integer> {
    List<Province> findAll();

    List<Province> findAllByProvinceName(String provinceName);
}
