package com.jihu.exer;

import org.junit.Test;

public class StringDemo2 {

    /**
     * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     *
     * 方式一：转换为char[]
     */
    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
            char[] arr = str.toCharArray();
            for (int x = startIndex,y = endIndex; x < y ;x++,y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    /**
     * 方式二:使用String的拼接
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public String reverse2(String str,int startIndex,int endIndex) {
        if(str !=null){
            //第一部分
            String reverseStr = str.substring(0,startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    /**
     * 方式三：使用StringBuffer/StringBuilder
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public String reverse3(String str,int startIndex,int endIndex) {
        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0,startIndex));
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String newStr1 = reverse(str, 0, str.length() - 1);
        System.out.println(newStr1);

        String newStr2 = reverse2(str,0,str.length()-1);
        System.out.println(newStr2);

        String newStr3 = reverse3(str,0,str.length()-1);
        System.out.println(newStr3);
    }
}
