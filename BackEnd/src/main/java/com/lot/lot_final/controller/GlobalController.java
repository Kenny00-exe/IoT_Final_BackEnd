package com.lot.lot_final.controller;

import com.alibaba.fastjson.JSONArray;
import com.lot.lot_final.entity.GlobalSum;
import com.lot.lot_final.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GlobalController {
    @Resource
    GlobalService globalService;

    @CrossOrigin
    @GetMapping(value="/api/getGlobalForecast")
    @ResponseBody
    public JSONArray getGlobalForecast(){
        return globalService.find();
    }

    @CrossOrigin
    @GetMapping(value="/api/getGlobalSum")
    @ResponseBody
    public List<GlobalSum> getGlobalSum(){
        return globalService.findAll();
    }
}
