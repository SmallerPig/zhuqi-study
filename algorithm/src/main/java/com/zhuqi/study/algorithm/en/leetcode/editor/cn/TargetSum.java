//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1614 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        int targetSumWays = solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("targetSumWays = " + targetSumWays);
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {

            backtrack(nums, target, 0, 0);

            return count;
        }

        /**
         * Success:
         * Runtime:645 ms, faster than 5.21% of Java online submissions.
         * Memory Usage:38.9 MB, less than 93.46% of Java online submissions.
         * <p>
         * Q1:为啥第一步就是要判断index ==nums.length?index 不等于nums.length不行吗?
         * <p>
         * <p>
         * Q2:这里的回溯为啥没有正常逻辑的回退一步的操作?
         *
         * @param nums
         * @param target
         * @param index
         * @param sum
         */
        public void backtrack(int[] nums, int target, int index, int sum) {
            if (index == nums.length) {
                //System.out.println("index = " + index);
                //System.out.println("nums = " + Arrays.toString(nums) + ", target = " + target + ", index = " + index + ", sum = " + sum);
                if (sum == target) {
                    count++;
                }
            } else {
                backtrack(nums, target, index + 1, sum + nums[index]);
                backtrack(nums, target, index + 1, sum - nums[index]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}