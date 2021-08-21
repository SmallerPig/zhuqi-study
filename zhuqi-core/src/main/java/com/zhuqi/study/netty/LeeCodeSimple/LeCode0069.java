package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 通过次数258,592提交次数659,464
 * @author zhuqi at 2021/2/19
 */
public class LeCode0069 {

    public static void main(String[] args) {

        LeCode0069 leCode0069 = new LeCode0069();
        int res = leCode0069.mySqrt1(2147395599);
        System.out.println("res = " + res);
    }



    public int mySqrt(int x) {
        int left =0, right = x;
        int mid = x;
        while (left<=right){
            if (mid*mid>x){
                right = mid;

                continue;
            }else if (mid*mid<=x && true){
                return mid;
            }
            left = mid;

            x= x/2;
        }

        return 1;
    }

    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }



}
