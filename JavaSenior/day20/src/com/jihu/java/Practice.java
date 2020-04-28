package com.jihu.java;

import org.junit.Test;

import java.util.*;

/**
 * 集合练习
 */
public class Practice {

    /**
     * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
     * 到小的顺序显示出来
     */
    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0 ; i < 10; i++){
            int source = scanner.nextInt();
            list.add(source);
        }

        Collections.sort(list,(Integer a,Integer b)->{
            return Integer.compare(b,a);
        });
        System.out.println(list);
    }

    @Test
    public void test2(){
        Student yangfan = new Student(1, "杨帆", 111);
        Student println = new Student(1, "println", 33);
        Student coco = new Student(1, "coco", 12);

        TreeSet<Student> students = new TreeSet<Student>((Student a,Student b)->{
            return Integer.compare(a.getScore(),b.getScore());
        });
        students.add(yangfan);
        students.add(println);
        students.add(coco);

//       while ()
    }
}

class  Student{
    private Integer id;
    private String name;
    private Integer score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student(Integer id, String name, Integer score) {

        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student() {

    }
}
