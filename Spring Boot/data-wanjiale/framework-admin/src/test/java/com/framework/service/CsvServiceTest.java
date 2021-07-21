package com.framework.service;


import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;

public class CsvServiceTest {
    public static void main(String[] args) {
        read("e:/参数表数据.csv");
    }

    public static void write(String filePath){
//        String filePath = "e:/test.csv";
        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));

            //CsvWriter csvWriter = new CsvWriter(filePath);
            // 写表头
            String[] headers = {"编号","姓名","年龄"};
            String[] content = {"123,65","张山","34"};
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(String filePath){
//        String filePath = "XXX.csv";
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath, ',',Charset.forName("UTF-8"));
            // 读表头
            csvReader.readHeaders();
            System.out.println(JSON.toJSONString(csvReader.getHeaders()));
            csvReader.readRecord();
            System.out.println("---------record-------");
            while (csvReader.readRecord()){
                // 读一整行
                System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                System.out.println(csvReader.get("brand"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
