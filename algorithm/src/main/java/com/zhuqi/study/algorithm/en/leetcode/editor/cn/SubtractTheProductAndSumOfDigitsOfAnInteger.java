//给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 
//
// 
//
// 示例 1： 
//
// 输入：n = 234
//输出：15 
//解释：
//各位数之积 = 2 * 3 * 4 = 24 
//各位数之和 = 2 + 3 + 4 = 9 
//结果 = 24 - 9 = 15
// 
//
// 示例 2： 
//
// 输入：n = 4421
//输出：21
//解释： 
//各位数之积 = 4 * 4 * 2 * 1 = 32 
//各位数之和 = 4 + 4 + 2 + 1 = 11 
//结果 = 32 - 11 = 21
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 
//
// Related Topics 数学 👍 145 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        System.out.println("args = " + (3 / 10));
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/08/09 19:10:43
         * Success:
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:38.1 MB, less than 84.94% of Java online submissions.
         *
         * @param n
         * @return
         */
        public int subtractProductAndSum(int n) {
            int mut = 1;
            int sum = 0;
            while (n > 0) {
                int t = 0;
                if (n < 10) {
                    t = n;
                } else {
                    t = n % 10;
                }
                //System.out.println("t = " + t);
                mut = mut * t;
                sum = sum + t;
                n = n / 10;
            }
            return (mut - sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}