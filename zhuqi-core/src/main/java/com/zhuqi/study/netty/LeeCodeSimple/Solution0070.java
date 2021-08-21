package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 * 1=>1
 * 2=>2
 * 3=>3
 * 4=>3+2=5
 * 5=>5+3=8
 * 6=>8+5=13
 *
 * 通过次数367,495提交次数714,308
 * @author zhuqi at 2021/2/20
 */
public class Solution0070 {
    public static void main(String[] args) {
        Solution0070 solution0070 = new Solution0070();
        int res = solution0070.climbStairs1(8);
        System.out.println("res = " + res);
    }

    public int climbStairs(int n) {
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }
    public int climbStairs1(int n) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>(){{
            put(0,1);
            put(1,1);
        }};

        for (int i = 2; i <= n; i++) {
            result.put(i,result.get(i-1)+result.get(i-2));
        }
        return result.get(n);
    }
}
