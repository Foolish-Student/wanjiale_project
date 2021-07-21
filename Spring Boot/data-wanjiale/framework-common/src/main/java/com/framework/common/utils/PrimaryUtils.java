package com.framework.common.utils;

import java.util.*;

public class PrimaryUtils {

    /** 时间格式(yyyyMMddHHmmss) */
    public final static String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 数据模型前缀
     */
    public static final String MODEL_CODE = "MD";
    /**
     * 数据源前缀
     */
    public static final String DATASOURCE_CODE = "DSO";
    /**
     * 数据集前缀
     */
    public static final String DATASET_CODE = "DSE";
    /**
     * 文件前缀
     */
    public static final String FILE_CODE = "FILE";

    public static final String PRI_CODE = "PRI";

    /**
     * 获取按照前缀日期格式自定义排列的主键
     *
     * @param pref 前缀
     * @return 返回pref+yyyyMMddHHmmss+三个随机数格式字符串
     */
    public static synchronized String getPrimaryKeyByPref(String pref) {
        Date nowTime = new Date();
        String  dateTimeStr = DateUtils.format(nowTime,DATE_TIME_PATTERN);
        Random rr = new Random();

        return String.format(Locale.ROOT,"%s_%s_%s%s%s",pref,dateTimeStr,rr.nextInt(9),rr.nextInt(9),rr.nextInt(9));
    }

    public static void main(String[] args) {
        // SL-20201229143329-810
        System.out.println(getPrimaryKeyByPref("SL"));
        Set<String> codes = new HashSet<>(2000);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            codes.add(getPrimaryKeyByPref("DUL"));
        }
        System.out.println("-------用时"+(System.currentTimeMillis()-start)+"毫秒");
        System.out.println(codes.size());
    }





}
