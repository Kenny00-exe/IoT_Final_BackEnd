package com.lot.lot_final.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.lot.lot_final.entity.User;
import com.lot.lot_final.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("api/login")
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("")
    public ResponseEntity<User>Login(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password
    ){
        try {
            User loginDTO = loginService.Login(name, password);
            if(loginDTO!=null){
                return ResponseEntity.ok(loginDTO);
            }
            else {
                return ResponseEntity.status(403).body(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("logout")
    public ResponseEntity<String> userLogout(
            @RequestParam(value = "id") Long id
    ){
        //StpUtil.logout(id);
        return ResponseEntity.ok("退出成功");
    }
}
