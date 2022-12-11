package com.lot.lot_final.service;

import com.alibaba.fastjson.JSONArray;
import com.lot.lot_final.dao.GlobalDAO;
import com.lot.lot_final.entity.ForecastEntity;
import com.lot.lot_final.entity.GlobalSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class GlobalService {
    @Resource
    GlobalDAO globalDAO;
    public JSONArray find(){
        List<GlobalSum> list =globalDAO.findAll();
        ArrayList<Integer> sum=new ArrayList<>(100);
        int target=20;
        int total=100;
        for(int i=0;i<target;i++){
            sum.add(list.get(target-i-1).sum);
        }
        ForecastService forecastService=new ForecastService();
        JSONArray forecast=forecastService.forecast(sum,target);

        Date date=list.get(0).date;

        List<ForecastEntity> forecastEntities=new ArrayList<>();

        JSONArray data=new JSONArray();

        for(int i=0;i<target;i++){
            ForecastEntity fore=new ForecastEntity();
            Calendar calendar=new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE,target-i);
            long longTime=calendar.getTime().getTime();
            java.sql.Date iDate=new java.sql.Date(longTime);
            fore.sum=list.get(target-i-1).sum;
            fore.date=iDate;
            data.add(fore);
        }

        for( int i=0;i<total;i++) {
            ForecastEntity fore=new ForecastEntity();
            long longTime=list.get(i).date.getTime();
            java.sql.Date iDate=new java.sql.Date(longTime);
            fore.sum=list.get(i).sum;
            fore.date=iDate;
            data.add(fore);
        }

        Collections.reverse(data);
        return data;
    }

    public List<GlobalSum> findAll(){
        List<GlobalSum> list=globalDAO.findAll().subList(0,99);
        return list;
    }

}
