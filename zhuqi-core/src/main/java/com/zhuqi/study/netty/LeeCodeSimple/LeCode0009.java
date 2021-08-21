package com.zhuqi.study.netty.LeeCodeSimple;

import java.security.interfaces.RSAKey;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *  
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * 通过次数559,804提交次数953,898
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/15
 */
public class LeCode0009 {
    public static void main(String[] args) {

        boolean palindrome = isPalindrome2(1124211);
        System.out.println("palindrome = " + palindrome);
    }

    /*
    调转字符串
     */
    public static boolean isPalindrome(int x) {
        if (x< 0){
            return false;
        }
        String sx = String.valueOf(x);

        for (int i =0; i < sx.length()/ 2;i++) {
            if (sx.charAt(i)!= sx.charAt(sx.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /*
        取余整除,防止溢出只取一半
     */
    public static boolean isPalindrome2(int x){
        if(x <0 || (x>0&& x%10==0)){
            return false;
        }
        int result =0;
        while (result < x){
            result =result*10 + x%10;
            x =x/10;
        }

        System.out.println("result = " + result);
        System.out.println("x = " + x);
        if (result == x || result/10 == x){
            return true;
        }
        return false;
    }

}
