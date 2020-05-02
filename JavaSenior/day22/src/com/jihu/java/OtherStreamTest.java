package com.jihu.java;


import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 *
 */
public class OtherStreamTest {

    /**
     * 1.标准的输入、输出流、
     * 1.1
     * System.in 标准的输入流，默认从键盘输入
     * System.out 标准的输出流，默认从控制台输出
     * 1.2
     * System的setIn(InputStream in)/setOut(PrintStream)方式重新指定输入和输出的流
     * 1.3练习:
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
     * 直至当输入“e”或者“exit”时，退出程序
     *
     * 方法一：使用Scanner实现
     * 方法二：使用System.in  --》BufferedReader的readLine()
     */
    @Test
    public void test1(){
        BufferedReader bufferedReader  = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true){
                System.out.println("请输入字符串:");
                String data = bufferedReader.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 3.数据流
     * 3.1 DataInputStream DataOutputStream
     * 3.2 作用：用于读取或写出基本数据类型的变量或字符串
     *
     *
     * 练习中，将内存中的字符串、基本数据类型，基本苏剧类型变量写入到文件中
     */
    @Test
    public void test3()  {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
            dataOutputStream.writeUTF("哈皮");
            //dataOutputStream.flush();
            dataOutputStream.writeInt(23);
            //dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4(){
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("data.txt"));
            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            boolean isMale = dataInputStream.readBoolean();
            System.out.println("name="+name);
            System.out.println("age="+age);
            System.out.println("isMale="+isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataInputStream != null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
