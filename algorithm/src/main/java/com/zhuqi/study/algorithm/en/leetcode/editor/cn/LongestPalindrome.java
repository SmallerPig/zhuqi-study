//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 539 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        int abccccdd = solution.longestPalindrome("ccc");
        System.out.println("ccc = " + abccccdd);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/15 11:06:27
         * Success:
         * Runtime:7 ms, faster than 33.58% of Java online submissions.
         * Memory Usage:39.9 MB, less than 29.27% of Java online submissions.
         *
         * @param s
         * @return
         */
        public int longestPalindrome(String s) {
            int length = s.length();
            int ans = 0;
            Map<Character, Integer> maps = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                maps.put(c, maps.getOrDefault(c, 0) + 1);
            }
            boolean flag = false;
            Iterator<Map.Entry<Character, Integer>> iterator = maps.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                Integer value = next.getValue();

                ans += (value / 2) * 2;
                if (value % 2 == 1 && ans % 2 == 0) {
                    ans++;
                }
            }


            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}