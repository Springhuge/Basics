package com.jihu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流 属于字符流
 *  InputStreamReader 将一个字节的输入流转换为字符的输入流
 *  OutputStreamWriter 将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 ---》字符数组、字符串
 *   编码：字符数组、字符串 ---》 字节、字节数组
 *
 * 4.字符集
 *
 *
 */
public class InputStreamReaderTest {

    @Test
    public void test1(){
        InputStreamReader inputStreamReader = null;

        try {
            FileInputStream  fileInputStream = new FileInputStream("dbcp.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len =  inputStreamReader.read(cbuf))!= -1){
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");

            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");

            char[] cbuf = new char[20];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1){
                outputStreamWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
