package com.jihu.java;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类；
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向，输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类                 节点流(或文件流)            缓冲流(处理流的一种)
 * InputStream              FileInputStream             BufferedInputStream
 * OutputStream             FileOutputStream            BufferedOutputStream
 * Reader                   FileReader                  BufferedReader
 * Writer                   FileWriter                  BufferedWriter
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 说明点
     * 1.read()的理解：返回读入的一个字符，如果达到文件末尾返回-1
     * 2.异常的处理，为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally
     * 3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void testFileReader(){
        FileReader fileReader = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt"); //
            //2.提供具体的流
            fileReader = new FileReader(file);
            //3.数据的读入
            //read()：返回读入的一个字符，如果达到文件末尾，返回-1
            //方式一
//        int data = fileReader.read();
//        while ( data != -1){
//            System.out.print((char) data);
//            data = fileReader.read();
//        }
            //方式二
            int data ;
            while ((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                //4.流的关闭
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader2(){
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt"); //

            //2.FileReader流的实例化
            fileReader = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuffer):返回每次读入cbuffer数组中字符的个数 如果达到文件末尾，返回-1
            char[] cbuffer = new char[5];
            int len;
            while ((len = fileReader.read(cbuffer)) != -1){
                //错误的写法
//                for(int i = 0;i <cbuffer.length;i++){
//                    System.out.println(cbuffer[i]);
//                }
                //正确的写法
//                for (int i = 0;i < len;i++){
//                    System.out.print(cbuffer[i]);
//                }
                //方式二：
                //错误的写法，对应着方式一的错误写法
//                String str = new String(cbuffer);
//                System.out.print(str);
                //正确的写法
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件里
     *
     * 说明
     * 1.输出操作，对应File是可以不存在的,并不会报异常
     * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     *   File对应的硬盘中的文件如果如果存在，对原有文件的覆盖
     *      如果流使用的构造器是:FileWriter(file,false) /FileWriter(file) 会对原有的文件进行覆盖
     *      如果流使用的构造器是:FileWtiter(file,true):不会对原有文件进行覆盖
     *
     */
    @Test
    public void testFileWriter(){
        FileWriter fileWriter = null;
        //1.提供一个File类的对象，指明写出到的文件
        try {
            File file = new File("hello.txt");

            //2.提供FileWtiter的对象，用户数据的写出
            fileWriter = new FileWriter(file,true);

            //3.写出的操作
            fileWriter.write("I have a dream!\n");
            fileWriter.write("you need to have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("1.jpg");
//            File destFile = new File("2.jpg");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while ((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
