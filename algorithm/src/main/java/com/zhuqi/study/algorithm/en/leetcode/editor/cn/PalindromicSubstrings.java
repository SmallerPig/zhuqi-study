//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1138 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        /**
         * > 2023/06/13 14:50:50
         * Success:
         * Runtime:9 ms, faster than 56.71% of Java online submissions.
         * Memory Usage:42.5 MB, less than 21.36% of Java online submissions.
         *
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            //1. 定义布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
            //2. 状态转移方程: 当s[i] = s[j], dp[i][j] = dp[i+1][j-1];
            //              否则,dp[i][j]=false
            //    注:由于就j>=i,所以只需要状态转移图的右上部分
            //3. 初始化,状态转移图可知,需要初始化的元素为dp[i][i]和dp[i][i+1].
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int count = 0;
            //初始化dp
            for (int i = 0; i < length; i++) {
                count++;
                dp[i][i] = true; //dp[i][i]表示单个元素,一定属于回文串
                if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                    dp[i][i + 1] = true; //相邻两个元素相同,一定属于回文串
                }
            }
            //状态转移方程,从初始化可知,dp更新时i从length-3开始, j从i+2开始.
            for (int i = length - 3; i >= 0; i--) {
                for (int j = i + 2; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
            return count;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}