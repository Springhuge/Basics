package com.jihu.java4;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //of(T t):保存t是非空的
        Optional<Girl> girl1 = Optional.of(girl);

    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t):t可以是为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化后的getGirlName
    public String getGirlName2(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return boy.getGirl().getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    //使用Optional的getGirlName2
    public String getGirlName3(Boy boy){
        if(Optional.ofNullable(boy).isPresent()){
            Girl girl = boy.getGirl();
            if(Optional.ofNullable(girl).isPresent()){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test5(){
        Boy boy = new Boy();
        String girlName = getGirlName3(boy);
        System.out.println(girlName);
    }

}
