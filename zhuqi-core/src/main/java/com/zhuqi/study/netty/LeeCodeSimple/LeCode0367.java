package com.zhuqi.study.netty.LeeCodeSimple;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 * 通过次数54,900提交次数125,662
 * @author zhuqi at 2021/2/20
 */
public class LeCode0367 {

    public static void main(String[] args){
        LeCode0367 leCode0367 = new LeCode0367();
        boolean perfectSquare = leCode0367.isPerfectSquare(225);
        System.out.println("res = " + perfectSquare);

    }


    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left<= right){
            int mid = left + (right-left)/2;
            long midSqre = (long) mid*mid;
            if (midSqre == num){
                return true;
            }else if (midSqre>num){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return false;
    }
}
