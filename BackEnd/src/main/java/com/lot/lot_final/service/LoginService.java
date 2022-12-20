package com.lot.lot_final.service;
import cn.dev33.satoken.stp.StpUtil;
import com.lot.lot_final.dao.UserDAO;
import com.lot.lot_final.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginService {

    @Resource
    UserDAO userDAO;

    public User Login(String name, String password) {
        List<User>users=userDAO.findAllByNameAndPassword(name,password);
        if(users.size()==0){
            return null;
        }
        StpUtil.login(users.get(0).getId());
        return users.get(0);
    }
}
