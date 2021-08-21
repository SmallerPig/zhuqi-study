package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * 通过次数14,181提交次数31,990
 * @author zhuqi at 2021/2/21
 */
public class Solution1483 {

    public static void main(String[] args){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(100);
        treeSet.add(87);
        treeSet.add(66);
        treeSet.add(89);
        treeSet.add(44);
        treeSet.add(24);

        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.first() = " + treeSet.first());
        System.out.println("treeSet.last() = " + treeSet.last());

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(1,2);
        treeMap.put(2,2);
        treeMap.put(3,3);
        treeMap.put(3,4);
        treeMap.put(4,3);
        treeMap.put(4,4);
        treeMap.put(4,5);
        treeMap.put(4,1);
        treeMap.getOrDefault(4,1);
        System.out.println("treeMap.lastKey() = " + treeMap.lastKey());
        System.out.println("treeMap.firstKey() = " + treeMap.firstKey());

        Solution1483 solution1483 = new Solution1483();
        int res1 = solution1483.longestSubarray(new int[]{8, 2, 4, 7}, 4);
        System.out.println("res1 = " + res1);
        int res2 = solution1483.longestSubarray(new int[]{10,1,2,4,7,2}, 5);
        System.out.println("res2 = " + res2);
        int res3 = solution1483.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 3);
        System.out.println("res3 = " + res3);
        int res4 = solution1483.longestSubarray(new int[]{8}, 10);
        System.out.println("res4 = " + res4);


    }


    /**
     * 双指针算法实现
     * 该方法没有问题,但在力扣上显示超时,所以使用跟更好的方法2来解决
     * 正好借助此题了解了java的TreeMap
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray0(int[] nums, int limit) {
        int result = 0;
        int length = nums.length;
        if (length==1){
            return length;
        }
        // 第一个指针,left
        for (int i = 0; i < length; i++) {
            //当前数组最大值 max value of current index nums
            int max = nums[i];
            //当前数组最小值
            int min = nums[i];
            for (int j = i+1; j < length; j++) {
                max=Math.max(nums[j], max);
                min=Math.min(nums[j], min);
                if (max-min<=limit){
                    result = Math.max(j-i, result);
                }
            }
        }

        return result;
    }


    public int longestSubarray1(int[] nums, int limit){
        int length = nums.length;
        if (length==1){
            return 1;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            TreeSet<Integer> treeSet = new TreeSet<Integer>();
            treeSet.add(nums[i]);
            for (int j = i+1; j < length; j++) {
                treeSet.add(nums[j]);
                int tempResult = treeSet.last()-treeSet.first();
                if (tempResult<=limit){
                    result = Math.max(result, tempResult);
                }else{
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 练习滑动窗口方法
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray2(int[] nums, int limit) {
        int length = nums.length;
        int left = 0, right = 0;
        int result = 0;
        TreeMap<Integer, Integer> maps = new TreeMap<>();
        while (right < length) {
            maps.put(nums[right], maps.getOrDefault(nums[right], 0) + 1);
            //
            while (maps.lastKey() - maps.firstKey() > limit) {
                maps.put(nums[left], maps.get(nums[left]) - 1);
                if (maps.get(nums[left]) == 0) {
                    maps.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;

    }



    /**
     * 官方解法,滑动窗口
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        // 第一个为数组中的元素值,第二个为出现的数量
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }

}
