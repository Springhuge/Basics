package com.jihu.exer;

import org.junit.Test;

public class StringDemo4 {

    /**
     *4.获取两个字符串中最大相同子串。比如：
     *  str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
     *  提示：将短的那个串进行长度依次递减的子串与较长
     *  的串比较。
     */
    //前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr ;
            String minStr;
            if(str1.length() >= str2.length()){
                maxStr = str1;
                minStr = str2;
            }else{
                maxStr = str2;
                minStr = str1;
            }
            int length = minStr.length();
            for(int i = 0;i < length;i++){
                for(int x = 0,y= length-i;y <= length;x++,y++){
                    String subStr =  minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
     return null;
    }

    @Test
    public void testGetMaxSameString () {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);
    }


}
