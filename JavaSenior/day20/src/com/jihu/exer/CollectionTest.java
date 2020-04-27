package com.jihu.exer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);
    }
}
