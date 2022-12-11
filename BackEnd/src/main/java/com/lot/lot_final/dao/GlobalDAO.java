package com.lot.lot_final.dao;

import com.lot.lot_final.entity.GlobalSum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GlobalDAO extends JpaRepository<GlobalSum,Integer> {
    @Override
    List<GlobalSum> findAll();

}
