//给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，
//你想知道你拥有的石头中有多少是宝石。 
//
// 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：jewels = "aA", stones = "aAAbbbb"
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：jewels = "z", stones = "ZZ"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= jewels.length, stones.length <= 50 
// jewels 和 stones 仅由英文字母组成 
// jewels 中的所有字符都是 唯一的 
// 
//
// Related Topics 哈希表 字符串 👍 766 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        /**
         * > 2023/07/24 15:11:42
         * Success:
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39.5 MB, less than 98.59% of Java online submissions.
         *
         * @param jewels
         * @param stones
         * @return
         */
        public int numJewelsInStones(String jewels, String stones) {
            int ans = 0;
            for (char c : stones.toCharArray()) {
                if (jewels.indexOf(c) != -1) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}