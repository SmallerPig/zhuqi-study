package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/16
 */
public class LeCode0020 {

    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);

    }


    public static boolean isValid(String s) {

        int length = s.length();
        if (length %2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        HashMap<Character, Character> map = new HashMap<Character, Character>(){{
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }};

        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.empty() ||s.charAt(i)!= map.get(stack.peek())) {
                return false;
            }else {
                stack.pop();
            }
        }

        return stack.empty();
    }

    public static boolean isValid2(String s){
        int length = s.length();
        if (length %2 != 0){
            return false;
        }
        int beginIndex = length/2;
        for (int i = beginIndex; i < length; i++) {
            if (s.charAt(i)!= fan(s.charAt(length-1-beginIndex))){
                return false;
            }

        }
        return true;
    }

    public static boolean isValid4(String s){
        int length = s.length();
        if (length %2 != 0){
            return false;
        }

        for(Character c: s.toCharArray()){

        }
        return false;
    }

    /*
    官方解法
     */
    public static boolean isValid3(String s) {
         int n = s.length();
         if (n % 2 == 1) {
             return false;
         }

         Map<Character, Character> pairs = new HashMap<Character, Character>() {{
             put(')', '(');
             put(']', '[');
             put('}', '{');
         }};
         Deque<Character> stack = new LinkedList<Character>();
         for (int i = 0; i < n; i++) {
             char ch = s.charAt(i);
             if (pairs.containsKey(ch)) {
                 if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                     return false;
                 }
                 stack.pop();
             } else {
                 stack.push(ch);
             }
         }
         return stack.isEmpty();

     }

    public static char fan(char c){
        if (c == ')'){
            return '(';
        }if (c == ']'){
            return '[';
        }
        return '{';

    }


}
