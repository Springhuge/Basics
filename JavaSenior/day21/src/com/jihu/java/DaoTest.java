package com.jihu.java;

import org.junit.Test;

import java.util.List;

public class DaoTest {

    @Test
    public void test1(){
        CustomDao customDao = new CustomDao();
        customDao.add(new Customer());

        List forList = customDao.getForList(10);

        StudentDao studentDao = new StudentDao();
        Student index = studentDao.getIndex(1);



    }
}
