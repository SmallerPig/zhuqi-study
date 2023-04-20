//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1449 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/04/20 19:46:54
         * Success:
         * Runtime:7 ms, faster than 43.57% of Java online submissions.
         * Memory Usage:45.1 MB, less than 15.04% of Java online submissions.
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> maps = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);

                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(aChar);
                }
                String s = sb.toString();
                List<String> strings = maps.get(s);
                if (strings == null) {
                    strings = new ArrayList<>();
                }
                strings.add(str);

                maps.put(s, strings);
            }

            return new ArrayList<>(new ArrayList<>(maps.values()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}