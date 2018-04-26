package com.zhuhe;

import java.io.*;
import java.util.Properties;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class ConfigFileHelper {
    public final static String LEFT_UP = "leftUp";
    public final static String LEFT_DOWN = "leftDown";
    public final static String RIGHT_UP = "rightUp";
    public final static String RIGHT_DOWN = "rightDown";

    public static void read() throws IOException {
        Properties prop = new Properties();  //创建properties对象
        InputStream in = new FileInputStream("conf/my.properties"); //将文件变成文件流
        prop.load(in);  //core 讲流load进

        //修改name的属性值
        prop.setProperty("name", "Vermouth");
        //添加一个新的属性studio
        prop.setProperty("studio", "Boxcode Studio");
        //文件输出流
        FileOutputStream fos = new FileOutputStream("config/config.properties");  //相对路径
        prop.store(fos, "Copyright (c) Boxcode Studio"); //保存到properties文件里  后面的参数会加在properties文件的首行
        fos.close();//关闭流
    }

    public static int readPro(String key) throws IOException {
        Properties prop = new Properties();  //创建properties对象
        InputStream in = new FileInputStream("config/config.properties"); //将文件变成文件流
        prop.load(in);  //core 讲流load进
        String property = prop.getProperty(key);
        in.close();

        try {
            int value = Integer.parseInt(property);
            return value;
        } catch (Exception e) {
            return QuickActionType.UNKOWN.getValue();
        }
    }
}
