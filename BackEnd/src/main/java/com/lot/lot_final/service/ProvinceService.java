package com.lot.lot_final.service;

import com.alibaba.fastjson.JSONArray;
import com.lot.lot_final.dao.ProvinceDAO;
import com.lot.lot_final.dao.ProvinceLatestDAO;
import com.lot.lot_final.entity.Country;
import com.lot.lot_final.entity.ForecastEntity;
import com.lot.lot_final.entity.Province;
import com.lot.lot_final.entity.ProvinceLatest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProvinceService {
    @Resource
    ProvinceDAO provinceDAO;
    @Resource
    ProvinceLatestDAO provinceLatestDAO;

    public List<Province> findAllByName(String name){
        return provinceDAO.findAllByProvinceName(name);
    }


    public List<ProvinceLatest> findProvinceLatest(){
        Sort s = Sort.by(Sort.Direction.DESC,"provinceConfirmedCount");
        return provinceLatestDAO.findAll(s);
    }

    public List<ForecastEntity> getForecast(String name){
        ArrayList<Integer> sum=new ArrayList<Integer>(100);
        List<Province> lists=provinceDAO.findAllByProvinceName(name);
        List<ForecastEntity> forecastList=new ArrayList<>(100);
        int dataSum=100;
        int target=20;
        for(int i=0;i<target;i++){
            sum.add(lists.get(target-1-i).provinceConfirmedCount);
        }

        ForecastService forecast=new ForecastService();
        JSONArray forecastNum=forecast.forecast(sum,target);

        Date date=lists.get(0).updateTime;
        for(int i=0;i<target;i++){
            ForecastEntity fore=new ForecastEntity();
            fore.sum=forecastNum.get(target-i-1);
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE,target-i);
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
            forecast2.sum=lists.get(i).provinceConfirmedCount;
            forecastList.add(forecast2);
        }

        return forecastList;
    }
}
