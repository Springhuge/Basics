package com.jihu.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *      并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 */
public class FileTest {

    /**
     * 1.如何创建File类的实例
     *  File(String filePath)
     *  File(String parentPath,String childPath)
     *  File(File parentPath,String childPath)
     *
     * 2.
     * 相对路径：相对于某个路径下，指明的路径
     * 绝对路径：包含盘符在内的文件或文件目录的路径
     *
     * 3.路径分隔符
     *  windows:\\
     *  unix:/
     *
     */
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相当于当前module
        File file2 = new File("");
        System.out.println(file1);

        //构造器2
        File file3 = new File("F:\\workspace\\atguigu\\Basics","JavaSenior");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\workspace\\atguigu\\Basics\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));
    }

    @Test
    public void test3(){
        File file = new File("F:\\workspace\\atguigu\\Basics\\JavaSenior");

        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * public boolean renameTo(File dest) 把文件重命名为指定的文件路径
     *  要想保证返回true，需要file1在硬盘中是存在，且file2不能在硬盘中存在
     *
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\workspace\\atguigu\\Basics\\JavaSenior\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("F:\\workspace\\atguigu\\Basics\\JavaSenior");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("F:\\workspace\\atguigu\\Basics\\JavaSenior\\虎哥NB");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }


        File file2 = new File("F:\\workspace\\atguigu\\Basics\\JavaSenior\\虎哥NB2");

        boolean mkdi2 = file2.mkdirs();
        if(mkdi2){
            System.out.println("创建成功2");
        }
    }

}
