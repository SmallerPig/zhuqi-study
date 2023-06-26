//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3833 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        boolean valid = solution.isValid("()[]");
        System.out.println("valid = " + valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        /**
         * > 2023/06/26 19:14:56
         * Success:
         * Runtime:2 ms, faster than 49.88% of Java online submissions.
         * Memory Usage:39.5 MB, less than 78.05% of Java online submissions.
         *
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            int index = 0, length = s.length();
            if (length % 2 == 1) {
                return false;
            }
            Deque<Character> deque = new LinkedList<>();
            Map<Character, Character> maps = new HashMap<>();
            maps.put(')', '(');
            maps.put(']', '[');
            maps.put('}', '{');
            while (index < length) {
                char c = s.charAt(index);
                if (maps.containsKey(c)) {
                    if (deque.isEmpty()) {
                        return false;
                    }
                    Character character = maps.get(c);
                    Character character1 = deque.removeFirst();
                    if (!character.equals(character1)) {
                        return false;
                    }
                } else {
                    deque.addFirst(c);
                }
                index++;
            }

            return deque.isEmpty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}