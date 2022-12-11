package com.lot.lot_final.controller;

import com.lot.lot_final.entity.ForecastEntity;
import com.lot.lot_final.entity.Province;
import com.lot.lot_final.entity.ProvinceLatest;
import com.lot.lot_final.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProvinceController {
    @Resource
    ProvinceService provinceService;

    @CrossOrigin
    @GetMapping(value="/api/getProvince")
    @ResponseBody
    public List<Province> getAll(@RequestParam String name){
        return provinceService.findAllByName(name);
    }

    @CrossOrigin
    @GetMapping(value="/api/getProvinceLatest")
    @ResponseBody
    public  List<ProvinceLatest> getLatestAll(){
        return provinceService.findProvinceLatest();
    }

    @CrossOrigin
    @GetMapping(value = "/api/getProvinceForecast")
    @ResponseBody
    public List<ForecastEntity> getProvinceForecast(@RequestParam String name){
        return provinceService.getForecast(name);
    }
}
