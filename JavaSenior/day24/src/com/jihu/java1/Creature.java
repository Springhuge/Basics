package com.jihu.java1;

import java.io.Serializable;

public class Creature<T> implements Serializable {

    private static final long serialVersionUID = 5998558907906311436L;

    private char gender;

    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
