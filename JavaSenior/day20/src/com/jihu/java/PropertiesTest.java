package com.jihu.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    //Properties:常用来处理配置文件，key 和 value 都是String类型
    public static void main(String[] args)  {
        FileInputStream inputStream = null;
        try {
            Properties properties = new Properties();

            inputStream = new FileInputStream("F:\\workspace\\atguigu\\Basics\\JavaSenior\\day20\\src\\com\\jihu\\java\\jdbc.properties");
            properties.load(inputStream);//加载流对应的文件
            String name =  properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = "+ name + ",password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream !=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
