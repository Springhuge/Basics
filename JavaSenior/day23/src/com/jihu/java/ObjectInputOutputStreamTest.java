package com.jihu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流，它的强大之处就是可以把java中的
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求。建Person
 *
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程:将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutStream实现
     */
    @Test
    public void testObjectOutStream(){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));

            objectOutputStream.writeObject(new String("我爱北京天安门"));
            objectOutputStream.flush();
            objectOutputStream.writeObject(new Person("王铭",23));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));

            Object object = objectInputStream.readObject();
            String str = (String) object;
            Person person = (Person) objectInputStream.readObject();
            System.out.println(str);
            System.out.println(person);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
