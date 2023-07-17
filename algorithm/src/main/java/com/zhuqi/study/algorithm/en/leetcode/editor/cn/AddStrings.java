//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 754 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.Stack;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        String s = solution.addStrings("456", "77");
        System.out.println("s = " + s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        /**
         * > 2023/07/17 19:00:28
         * Success:
         * Runtime:5 ms, faster than 10.70% of Java online submissions.
         * Memory Usage:42.5 MB, less than 12.47% of Java online submissions.
         *
         * @param num1
         * @param num2
         * @return
         */
        public String addStrings(String num1, String num2) {
            int l1 = num1.length(), l2 = num2.length();
            int sp = Math.abs(l1 - l2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sp; i++) {
                sb.append("0");

            }
            String preZero = sb.toString();
            if (l1 > l2) {
                num2 = preZero + num2;
            } else {
                num1 = preZero + num1;
            }
            int l = Math.max(l1, l2);
            Stack<Integer> stack = new Stack<>();
            boolean flag = false;
            for (int i = l - 1; i >= 0; i--) {
                int i1 = num1.charAt(i) - '0';
                int i2 = num2.charAt(i) - '0';
                int tempSum = i1 + i2 + (flag ? 1 : 0);

                int i3 = (tempSum) % 10;
                stack.push(i3);
                flag = tempSum >= 10;
            }
            if (flag) {
                stack.push(1);
            }
            sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}