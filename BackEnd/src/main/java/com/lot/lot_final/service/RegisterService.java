package com.lot.lot_final.service;

import com.lot.lot_final.dao.UserDAO;
import com.lot.lot_final.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RegisterService {
    @Resource
    UserDAO userDAO;
    public Boolean userExist(String name) {
        List<User> users=userDAO.findAllByName(name);
        return users.size()!=0;
    }
}
