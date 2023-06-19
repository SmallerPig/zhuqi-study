//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 254 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        int i = solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println("i = " + i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/19 13:41:10
         * Success:
         * Runtime:7 ms, faster than 80.97% of Java online submissions.
         * Memory Usage:43.1 MB, less than 99.46% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int maxSumDivThree(int[] nums) {
            int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
            for (int num : nums) {
                int[] g = new int[3];
                System.arraycopy(f, 0, g, 0, 3);
                for (int i = 0; i < 3; ++i) {
                    g[(i + num % 3) % 3] = Math.max(g[(i + num % 3) % 3], f[i] + num);
                }
                f = g;
            }
            return f[0];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}