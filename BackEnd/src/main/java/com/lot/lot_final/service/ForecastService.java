package com.lot.lot_final.service;

import java.io.*;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ForecastService {
    //读取json文件
    public Object read(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"gbk");
            int ch = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                stringBuffer.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = stringBuffer.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray forecast(ArrayList<Integer> data, int target) {
        JSONObject dataObject=new JSONObject();
        dataObject.put("target",target);
        dataObject.put("data",data);
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream("./loTData/data.json"), "gbk");
            osw.write(dataObject.toString());
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String exe = "python3";
        String command = "forecast.py";
//        String choice="Logistic";   //可选算法：1、Logistic；2、LSTM；
        String[] cmdArr = new String[] {exe, command};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmdArr);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        String ansFIle=(String) read("./loTData/ans.json");
        JSONObject ansObject = JSON.parseObject(ansFIle);
        JSONArray ans = ansObject.getJSONArray("ans");
        return ans;
    }

}
