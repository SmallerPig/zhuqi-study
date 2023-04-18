//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 3150 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int ans = 0;
            // dp的定义为以i为结尾的数组的最长递增子序列长度
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int temp = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        temp = Math.max(dp[j] + 1, temp);
                    }
                }
                dp[i] = temp;
                ans = Math.max(temp, ans);


            }

            return ans;

            //> 2023/04/18 17:44:55
            //Success:
            //	Runtime:53 ms, faster than 77.86% of Java online submissions.
            //	Memory Usage:41 MB, less than 45.18% of Java online submissions.
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}