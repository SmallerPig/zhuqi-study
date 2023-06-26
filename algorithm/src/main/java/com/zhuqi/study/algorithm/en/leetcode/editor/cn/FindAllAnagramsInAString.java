//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1201 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> needs = new HashMap<>();
            Map<Character, Integer> windows = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            int left = 0, right = 0, length = s.length();
            int validate = 0;
            for (Character c : p.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }

            //s = "cbaebabacd", p = "abc"
            // 0,6
            while (right < length) {
                char c = s.charAt(right);
                right++;


                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (needs.get(c).equals(windows.get(c))) {
                        validate++;
                    }
                }

                while (right - left >= p.length()) {
                    char cl = s.charAt(left);
                    if (needs.size() == validate) {
                        ans.add(left);
                    }
                    if (needs.containsKey(cl)) {
                        if (needs.get(cl).equals(windows.get(cl))) {
                            validate--;
                        }
                        windows.put(cl, windows.get(cl) - 1);
                    }

                    left++;
                }

            }


            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}