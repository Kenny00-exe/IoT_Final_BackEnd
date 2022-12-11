package com.lot.lot_final.dao;

import com.lot.lot_final.entity.ProvinceLatest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceLatestDAO extends JpaRepository<ProvinceLatest,Integer> {
    @Override
    List<ProvinceLatest> findAll();
}
