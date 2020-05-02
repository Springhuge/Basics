package com.jihu.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt,.doc,.java,.c,.cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt.......)，使用字节流处理
 *
 */
public class FIleInputOuputStreamTest {

    @Test
    public void testFileInputStream(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.造文件
            File file = new File("1.jpg");
            File file2 = new File("2.jpg");
            //2.造流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            //3.读数据
            byte[] buffer = new  byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }

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
            if(fileOutputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下的文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.造文件
            File file = new File(srcPath);
            File file2 = new File(destPath);
            //2.造流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            //3.读数据
            byte[] buffer = new  byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }

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
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "千锋Java教程：01.自定义框知识点与java反射复习.mp4";
        String destPath = "2.mp4";

        copyFile(srcPath,destPath);//345

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为:"+(end-start));

    }
}
