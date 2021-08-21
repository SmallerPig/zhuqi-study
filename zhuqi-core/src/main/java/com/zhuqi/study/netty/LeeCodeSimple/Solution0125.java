package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 通过次数201,614提交次数429,315
 * @author zhuqi at 2021/2/23
 */
public class Solution0125 {

    public static void main(String[] args){
        Solution0125 solution0125 = new Solution0125();
        System.out.println("solution0125.isPalindrome(\"OP\") = " + solution0125.isPalindrome("0P"));


    }

    public boolean isPalindrome(String s) {
        String allowStrings = "abcdefghigklfnopqrstuvwxyz0123456789";
        if (s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int length = s.length();
        int left =0, right = length-1;
        while (left<= right){
            if (allowStrings.indexOf(s.charAt(left))==-1){
                left++;
                continue;
            }
            if (allowStrings.indexOf(s.charAt(right))==-1){
                right--;
                continue;
            }

            if (s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
