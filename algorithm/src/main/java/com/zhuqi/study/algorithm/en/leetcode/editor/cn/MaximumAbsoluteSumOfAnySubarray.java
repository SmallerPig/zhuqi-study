//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下： 
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 103 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumAbsoluteSumOfAnySubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/08/08 20:15:33
         * Success:
         * Runtime:8 ms, faster than 21.43% of Java online submissions.
         * Memory Usage:54.9 MB, less than 6.12% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int maxAbsoluteSum(int[] nums) {
            int length = nums.length;
            int[] d1 = new int[length];
            int[] d2 = new int[length];
            d1[0] = nums[0];
            d2[0] = nums[0];
            int ans = Math.abs(nums[0]);
            for (int i = 1; i < length; i++) {
                d1[i] = Math.max(d1[i - 1] + nums[i], nums[i]);
                d2[i] = Math.min(d2[i - 1] + nums[i], nums[i]);
                int tempMax = Math.max(d1[i], Math.abs(d2[i]));

                ans = Math.max(ans, tempMax);
            }

            return ans;

//            for (int i = 0; i < length; i++) {
//                dp[i][i] = nums[i];
//            }
//            for (int i = 0; i < length; i++) {
//                for (int j = 0; j < i; j++) {
//
//                }
//            }
//
//
//            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}