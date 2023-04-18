//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 
// 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 
// 
//
// 
// 
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。 
// 
// 
//
// 子数组 是数组中的一个连续序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：3
//解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 529 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/04/18 19:30:24
         * Success:
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39 MB, less than 89.65% of Java online submissions.
         * 看清楚dp的定义尤为重要,需要理解下述代码中的dp[3]和dp[4]为啥等于0?
         *
         * @param nums
         * @return
         */
        public int numberOfArithmeticSlices(int[] nums) {
            int length = nums.length;
            if (length < 3) {
                return 0;
            }
            int ans = 0;
            // dp数组的定义为以当前index为结束(结尾)的数组中可以找出来的等差数列数量
            // 例如: [1,2,3,8,9,10]中 dp[0]=0,dp[1]=0,dp[2]=1,dp[3]=0, dp[4]=0, dp[5]=1;
            // 所以[1,2,3,8,9,10]的答案为0+0+1+0+0+1=2;
            int[] dp = new int[length];
            for (int i = 2; i < length; i++) {
                boolean flag = nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2];
                dp[i] = flag ? dp[i - 1] + 1 : 0;
                ans += dp[i];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}