package com.lot.lot_final.dao;

import com.lot.lot_final.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    @Override
    List<User> findAll();
    User findUserById(Integer id);
    List<User> findAllByName(String name);
    List<User> findAllByNameAndPassword(String name, String password);
}