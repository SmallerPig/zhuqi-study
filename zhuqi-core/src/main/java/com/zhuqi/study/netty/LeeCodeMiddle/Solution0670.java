package com.zhuqi.study.netty.LeeCodeMiddle;

import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 10^8]
 * 通过次数11,775提交次数27,437
 * @author zhuqi at 2021/2/26
 */
public class Solution0670 {

    public static void main(String[] args){
        System.out.println("maximumSwap(2736) = " + maximumSwap(2736));
    }


    public static int maximumSwap(int num) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (num > 0){
            stack.addFirst(num%10);
            num = num/10;
        }

        int pre = -1;
        int result = 0;
        while (!stack.isEmpty()){
            int current = stack.getFirst();
            if(current>pre && pre !=-1){

            }
            pre = current;
            result = result*10 + current;
        }

        return num;
    }
}
