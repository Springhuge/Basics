package com.jihu.java2;

import com.jihu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;

public class MethodTest {

    @Test
    public void test1(){

        Class clazz = Person.class;

        //getMethods() 获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("************************");

        //getDeclaredMethods() 获取当前运行时类中声明的所有方法 不包含父类中声明的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    /**
     * @Xxx
     * 权限修饰符 返回值类型 方法名(参数类型1 形参名1,.....) throws Exception{}
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //1.获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //2.权限修饰符
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //3.返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType+"\t");

            //4.方法名
            System.out.print(method.getName()+ "\t");

            //5.形参列表
            System.out.print("(");
            Class[] parameterTypes = method.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0)){
                for (int i =0; i < parameterTypes.length ; i++) {

                    if(i == parameterTypes.length -1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if(!(exceptionTypes == null || exceptionTypes.length == 0)){
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length -1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }


            System.out.println();
        }


    }
}
