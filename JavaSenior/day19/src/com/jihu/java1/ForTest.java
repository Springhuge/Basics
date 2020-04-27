package com.jihu.java1;

import org.junit.Test;

public class ForTest {

    @Test
    public void test1(){
        String[] str = new String[5];
        for (String myStr: str) {
            myStr = "Springhuge";
            System.out.println(myStr);
        }

        System.out.println("*****************************");

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
