package com.jihu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;


/**
 * 注解的使用
 *
 * 1.理解Annotation
 * ①jdk 5.0新增的功能
 * ②Annotation 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并且
 * 程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充西信息
 * ③JavaEE
 *
 *
 * 2.Annotation的使用示列
 *  示例一：生成文档的注释
 *  示列二：在编译时进行代码检查
 *  示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 *
 * 3.如何自定义注解 参照@SuppressWarning
 *  ①注解声明为@interface
 *  ②内部定义成员，通常使用value表示
 *  ③可以指定成员的默认值，使用default标识
 *  ④如果自定义注解没有成员，表明是一个标识作用
 *
 * 如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 * 自定义注解通常都会指明两个元注解 Retention 、 Target
 *
 * 4.jdk提供的4种元注解
 *  元注解：对现有注解进解释说明的注解
 *
 *  Retention 指定所修饰Annotation的生命周期，SOURCE\CLASS(默认行为)\RUNTIME
 *          只有声明为RUNTIME生命周期的注解，才能被反射获取
 *  Target     用于修饰Annotation 能用于修饰哪些元素
 *
 *  ***********出现频率较低******************
 *  Documented 用于指定该Annotation修饰的Annotation类将被javadoc解析时，保留下来
 *  Inherited 被它修饰的Annotation将具有继承性
 *
 * 5.通过反射来获取注解----到反射内容系统讲解
 *
 *
 * 6.jdk 8种注解的新特性：可重复注解、类型注解
 *
 * 6.1 可重复性注解 ①在MyAnnotation 上声明@Repeatable 成员值为MyAnnotations.class
 *                 ②MyAnnotation的Target和Retention和MyAnnotation相同
 *
 * 6.2 类型注解
 *
 * @author jihu
 *
 *
 */
public class AnnotationTest {

    @Test
    public void testGetAnnotation(){
        Class<Student> studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

@MyAnnotation(value = "hello")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

//@MyAnnotation(value = "ssss")
//@MyAnnotation(value = "hello")
//jdk 8之前写法
//@MyAnnotations(value = {
//        @MyAnnotation(value = "ssss"),
//        @MyAnnotation(value = "hello")
//})

class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}
