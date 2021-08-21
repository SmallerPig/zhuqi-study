package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.Arrays;

/**
 *
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 *
 * 提示：
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * 通过次数19,364提交次数33,836
 * @author zhuqi at 2021/2/23
 */
public class Solution1052 {

    public static void main(String[] args){
        Solution1052 solution1052 = new Solution1052();

        int res = solution1052.maxSatisfied(new int[]{10,1,7}, new int[]{0,0,0}, 2);
        System.out.println("res = " + res);

    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X){
        int sum1 = 0;
        for (int i = 0; i < customers.length; i++) {
            sum1+=customers[i];
        }
        int sum2 = 0;

        for (int i = 0; i < grumpy.length - X; i++) {
            int temp = 0;
            for (int j = i; j < i+X; j++) {
                if (grumpy[j] == 1){
                    temp+=customers[j];
                }
            }
            sum2 = Math.max(sum2, temp);
        }


        return sum1+sum2;

    }


    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length;
        int result = 0;
        for (int j = 0; j < length; j++) {
            int temp[] = Arrays.copyOf(grumpy, length);
            int sum = 0;

            for (int x = j; x < X+j; x++) {
                if (x< length){
                    temp[x] =0;
                }
            }

            for (int i = 0; i < length; i++) {
                if (temp[i]==0){
                    sum+= customers[i];
                }
            }

            result = Math.max(result, sum);
        }
        return result;
    }
}
