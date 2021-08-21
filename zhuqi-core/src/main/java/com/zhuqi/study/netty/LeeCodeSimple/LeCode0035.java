package com.zhuqi.study.netty.LeeCodeSimple;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 通过次数319,260提交次数679,045
 * @author zhuqi at 2021/2/18
 */
public class LeCode0035 {


    public static void main(String[] args) {
        LeCode0035 leCode0035 = new LeCode0035();
//        int result1 = leCode0035.searchInsert2(new int[]{1, 3, 5, 6}, 4);
        int result2 = leCode0035.searchInsert3(new int[]{1, 3, 5, 6}, 4);
//        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    /**
     * 盲写的方法1,暴力破解
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert0(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return length;
    }


    /**
     * 看了解题之后,使用二分查找法来解决问题
     *
     * 1,3,4,5,6    2
     *  nums[2]=4 >2
     * 1,3,4
     *  nums[1]=3>2
     * 1,3
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }

    public int searchInsert2(int[] nums, int target){
        int length = nums.length;
        int left = 0, right = length-1, res =length;
        while (left < right){
            int mid = right-left /2;
            if (nums[mid] >= target){
                res = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;
    }

    /**
     * 2.19复习二分查找法
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    int searchInsert3(int[] nums, int target){
        int length = nums.length;
        int result = 0;
        int l = 0, r= length-1;
        while (l<=r){
            int mid = (r-l)/2+l;
            if (nums[mid] >= target){
                result = mid;
                r = mid-1;

            }else {
                l = mid+1;
            }
        }
        return result;
    }
}
