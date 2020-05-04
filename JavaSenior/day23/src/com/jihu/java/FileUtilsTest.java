package com.jihu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("JavaSenior\\day23\\1.jpg");
        File destFile = new File("JavaSenior\\day23\\2.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
