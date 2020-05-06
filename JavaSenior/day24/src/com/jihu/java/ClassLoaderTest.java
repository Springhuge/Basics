package com.jihu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载机制
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        //使用系统类加载的getParent() 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        //sun.misc.Launcher$ExtClassLoader@47f37ef1 扩展类加载器
        System.out.println(classLoader1);

        //调用扩展类加载器的getPatent() 无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        //null 没有办法获取到
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /**
     * Properties:用来读取配置文件
     */
    @Test
    public void test2(){
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;

        try {
            Properties properties = new Properties();
            //此时的文件默认在当前的module下
            //读取配置文件方式一
//            fileInputStream = new FileInputStream("jdbc.properties");
            fileInputStream = new FileInputStream("src\\jdbc1.properties");
            properties.load(fileInputStream);

            //读取配置文件的方式二 使用ClassLoader
            //配置文件默认识别为：当前module的src下
//            ClassLoader classLoader = this.getClass().getClassLoader();
//            inputStream = classLoader.getResourceAsStream("jdbc1.properties");
//            properties.load(inputStream);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            System.out.println("user = " + user +".password="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
