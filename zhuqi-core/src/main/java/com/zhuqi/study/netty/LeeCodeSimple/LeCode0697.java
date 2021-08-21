package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * 通过次数34,030提交次数59,918
 * @author zhuqi at 2021/2/20
 */
public class LeCode0697 {

    public static void main(String[] args) {
        LeCode0697 leCode0697 = new LeCode0697();
        int shortestSubArray1 = leCode0697.findShortestSubArray(new int[]{1, 2, 3, 4, 5, 2});
        System.out.println("shortestSubArray1 = " + shortestSubArray1);
        int shortestSubArray2 = leCode0697.findShortestSubArray(new int[]{1, 2, 2, 3, 1});
        System.out.println("shortestSubArray2 = " + shortestSubArray2);
        int shortestSubArray3 = leCode0697.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println("shortestSubArray3 = " + shortestSubArray3);
    }


    public int findShortestSubArray(int[] nums) {
        int result  = Integer.MAX_VALUE;
        int length = nums.length;
        int max =0;
        //三个数:第一个为当前数字出现次数,第二个为初始开始位置,第三个为最后出现的位置
        Map<Integer, int[]> maps = new HashMap<Integer, int[]>();
        for (int i = 0; i < length; i++) {
            int v = nums[i];
            if (maps.containsKey(v)){
                int[] ints = maps.get(v);
                ints[0]++;
                ints[2]=i;
                maps.put(v, ints);
            }else {
                maps.put(v, new int[]{1,i,i});
            }
            max = Math.max(maps.get(v)[0], max);
        }

        for (Map.Entry<Integer, int[]> entry : maps.entrySet()) {
            if (entry.getValue()[0] == max){
                int[] value = entry.getValue();
                result = Math.min(value[2]-value[1] +1, result);
            }
        }
        return result;
    }
}
