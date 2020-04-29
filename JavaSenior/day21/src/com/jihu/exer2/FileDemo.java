package com.jihu.exer2;


import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        //创建一个与File同目录下的另外一个文件，文件名为haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }

    @Test
    public void test2(){

    }



}
