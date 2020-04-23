package com.jihu.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1.模拟一个trim方法，去除字符串两端的空格。
 *
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * 3.获取一个字符串在另一个字符串中出现的次数。
 *    比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
 *    中出现的次数
 *
 *4.获取两个字符串中最大相同子串。比如：
 *  str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
 *  提示：将短的那个串进行长度依次递减的子串与较长
 *  的串比较。
 *
 *5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
 *提示：
 *1）字符串变成字符数组。
 *2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 *3）将排序后的数组变成字符串。
 *
 */
public class StringDemo1 {

    /**
     * 1.模拟一个trim方法，去除字符串两端的空格。
     * @return String 返回去掉首位空格的新的String
     */
    public  String myTrim(String str){
        if(str != null){
            int start = 0; // 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length()-1; // 用于记录从后往前首次索引位置不是空格的位置的索引
            while (start < end && str.charAt(start) == ' '){
                start++;
            }
            while (start < end && str.charAt(end) == ' '){
                end--;
            }
            return str.substring(start,end+1);
        }
        return null;
    }

    @Test
    public void testTrim(){
        String str = " applicationContext   ";
        String newStr = myTrim(str);
        System.out.println(newStr);
    }


}
