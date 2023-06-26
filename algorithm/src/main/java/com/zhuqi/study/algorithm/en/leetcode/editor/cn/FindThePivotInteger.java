//给你一个正整数 n ，找出满足下述条件的 中枢整数 x ： 
//
// 
// 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。 
// 
//
// 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：6
//解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 是中枢整数，因为 1 = 1 。
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：-1
//解释：可以证明不存在满足题目要求的整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数学 前缀和 👍 43 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class FindThePivotInteger {
    public static void main(String[] args) {
        Solution solution = new FindThePivotInteger().new Solution();
        int i8 = solution.pivotInteger(8);
        System.out.println("i8 = " + i8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/26 15:34:46
         * Success:
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:38.6 MB, less than 31.81% of Java online submissions.
         *
         * @param n
         * @return
         */
        public int pivotInteger(int n) {
            if (n == 1) {
                return 1;
            }
            int ans = -1;
            int pre = 0;
            // 1
            // 2-3
            // 3-6
            // 4-10
            // 5-15
            int totalSum = (1 + n) * (n / 2) + ((n % 2 == 0) ? 0 : (n / 2) + 1);
            for (int i = 0; i < n; i++) {
                pre = pre + i;
                if (pre == totalSum - pre + i) {
                    return i;
                }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}