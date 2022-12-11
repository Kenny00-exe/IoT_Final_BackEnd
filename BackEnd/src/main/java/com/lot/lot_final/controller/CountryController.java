package com.lot.lot_final.controller;

import com.lot.lot_final.entity.Country;
import com.lot.lot_final.entity.CountryLatest;
import com.lot.lot_final.entity.ForecastEntity;
import com.lot.lot_final.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CountryController {
    @Resource
    CountryService countryService;

    @CrossOrigin
    @GetMapping(value="/api/getData")
    @ResponseBody
    public List<CountryLatest> getLatestAll(){
        return countryService.getLatestAll();
    }

    @CrossOrigin
    @GetMapping(value = "/api/getChinaNew")
    @ResponseBody
    public int getChinaNow(){
        List<Country> list= countryService.findAllByCountryName("中国");
        return list.get(0).confirmedCount-list.get(1).confirmedCount;
    }

    @CrossOrigin
    @GetMapping(value = "/api/getCountryNow")
    @ResponseBody
    public CountryLatest getCountryNow(@RequestParam String name){
        return countryService.findByCountryName(name);
    }

    @CrossOrigin
    @GetMapping(value = "/api/getCountryForecast")
    @ResponseBody
    public List<ForecastEntity> getCountryForecast(@RequestParam String name){
        return countryService.getForecast(name);
    }

    @CrossOrigin
    @GetMapping(value = "/api/getCountry")
    @ResponseBody
    public List<Country> getCountry(@RequestParam String name){
        return countryService.findAllByCountryName(name);
    }

}
