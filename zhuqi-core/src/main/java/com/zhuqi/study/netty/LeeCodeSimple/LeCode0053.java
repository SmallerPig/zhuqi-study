package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 通过次数417,365提交次数783,285
 * @author zhuqi at 2021/2/18
 */
public class LeCode0053 {

    public static void main(String[] args) {
        LeCode0053 leCode0053 = new LeCode0053();
        int res = leCode0053.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        int res = leCode0053.maxSubArray(new int[]{-1});
        System.out.println("res53 = " + res);

    }

    /**
     * 2021年的写法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum =nums[0];
        for (int i = 0; i < length; i++) {
            int currSum = nums[i];
            int currMax = nums[i];
            for (int j = i+1; j < length; j++) {
                currSum = currSum + nums[j];
                currMax = Math.max(currMax, currSum);
            }
            sum = Math.max(sum, currMax);
        }
        return sum;
    }

    /**
     * 2020年的写法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        int currentSum = nums[0];
        int len = nums.length;
        for(int i =1; i < len; i ++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            result = Math.max(currentSum, result);
        }
        return result;
    }


}
