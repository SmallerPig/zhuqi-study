package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 通过次数157,373提交次数214,023
 * @author zhuqi at 2021/2/20
 */
public class LeCode0349 {

    public static void main(String[] args){
        LeCode0349 leCode0349 = new LeCode0349();
        int[] res = leCode0349.intersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 3, 5});
        System.out.println("res = " + res);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            numsList.add(nums2[i]);
        }
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (numsList.contains(nums1[i])){
                resultSet.add(nums1[i]);
            }
        }
        int[] result = new int[resultSet.size()];

        int idx =0;
        for(int i: resultSet){
            result[idx] = i;
            idx++;
        }
        return result;
    }
}
