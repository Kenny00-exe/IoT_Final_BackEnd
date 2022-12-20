package com.lot.lot_final.controller;

import com.lot.lot_final.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    @Resource
    RegisterService registerService;

    @GetMapping("")
    public ResponseEntity<String> varifyAcademic(
            @RequestParam(value = "name") String name
    ){
        try {
            if(registerService.userExist(name)){
                return ResponseEntity.status(403).body("用户名已存在");
            }
            return ResponseEntity.ok("验证通过");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(404).body("出错");
        }
    }


}