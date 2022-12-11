package com.lot.lot_final.service;

import com.alibaba.fastjson.JSONArray;
import com.lot.lot_final.dao.CountryDAO;
import com.lot.lot_final.dao.CountryLatestDAO;
import com.lot.lot_final.entity.Country;
import com.lot.lot_final.entity.CountryLatest;
import com.lot.lot_final.entity.ForecastEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CountryService {
    @Resource
    CountryDAO countryDAO;
    @Resource
    CountryLatestDAO countryLatestDAO;

    public List<CountryLatest> getLatestAll(){
        //Sort s = Sort.by(Sort.Direction.DESC,"province_confirmed_count");
        return countryLatestDAO.findAll();
    }

    public List<Country> findAllByCountryName(String name){
        return countryDAO.findAllByCountryName(name);
    }

    public CountryLatest findByCountryName(String countryName){
        return countryLatestDAO.findByCountryName(countryName);
    }

    public List<ForecastEntity> getForecast(String countryName){
        ArrayList<Integer> sum=new ArrayList<Integer>(100);
        List<Country> lists=countryDAO.findAllByCountryName(countryName);
        List<ForecastEntity> forecastList=new ArrayList<>(100);
        if(lists.isEmpty())
            return forecastList;
        int dataSum=100;
        int target;
        if(lists.size()<=20)
        {
            target= lists.size();
        }
        else
            target=20;
        for(int i=0;i<target;i++){
            sum.add(lists.get(target-1-i).confirmedCount);

        }
        ForecastService forecast=new ForecastService();
        JSONArray forecastNum=forecast.forecast(sum,target);

        Date date=lists.get(0).updateTime;
        for(int i=0;i<target;i++){
            ForecastEntity fore=new ForecastEntity();
            fore.sum=forecastNum.get(target-i-1);
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,target-i);
            long longTime=calendar.getTime().getTime();
            java.sql.Date iDate=new java.sql.Date(longTime);
            fore.date=iDate;
            forecastList.add(fore);
        }

        for(int i=0;i<dataSum;i++){
            ForecastEntity forecast2=new ForecastEntity();
            long longTime=lists.get(i).updateTime.getTime();
            java.sql.Date iDate=new java.sql.Date(longTime);
            forecast2.date=iDate;
            forecast2.sum=lists.get(i).confirmedCount;
            forecastList.add(forecast2);
        }

        return forecastList;
    }


}
