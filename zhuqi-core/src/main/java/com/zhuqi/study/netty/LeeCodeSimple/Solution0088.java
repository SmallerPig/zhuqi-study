package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 通过次数269,917提交次数546,627
 * @author zhuqi at 2021/2/20
 */
public class Solution0088 {


    public static void main(String[] args){
        Solution0088 solution0088 = new Solution0088();
        solution0088.merge1(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n){
//        System.arraycopy();
        if(m==0){
            nums1 = nums2;
        }
        if(n==0){
            return;
        }

        int[] temp = nums1;
        int index1=0, index2=0;
        for (int i = 0; i < m+n; i++) {
            if (temp[index1]>=nums2[index2]|| index1>=m){
                nums1[i] = nums2[index2];
                index2++;
            }else {
                nums1[i] = nums1[index1];
                index1++;
            }
        }
    }
}
