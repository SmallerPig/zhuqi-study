//给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号： 
//
// 
// 最高有效位 上的数字分配到 正 号。 
// 剩余每位上数字的符号都与其相邻数字相反。 
// 
//
// 返回所有数字及其对应符号的和。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 521
//输出：4
//解释：(+5) + (-2) + (+1) = 4 
//
// 示例 2： 
//
// 
//输入：n = 111
//输出：1
//解释：(+1) + (-1) + (+1) = 1
// 
//
// 示例 3： 
//
// 
//输入：n = 886996
//输出：0
//解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 
//
// Related Topics 数学 👍 32 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class AlternatingDigitSum {
    public static void main(String[] args) {
        Solution solution = new AlternatingDigitSum().new Solution();
        int i = solution.alternateDigitSum(521);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/07/12 10:59:13
         * Success:
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:38.4 MB, less than 32.78% of Java online submissions.
         *
         * @param n
         * @return
         */
        public int alternateDigitSum(int n) {
            String s = String.valueOf(n);
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int cur = c - '0';
                //System.out.println("cur = " + cur);
                if (i % 2 != 1) {
                    ans += cur;
                } else {
                    ans -= cur;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}