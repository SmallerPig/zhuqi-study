package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * @author zhuqi at 2021/3/8
 */
public class Solution0022 {

    public static void main(String[] args) {

        String s = "zhuuhqi";
        int n = s.length();



        int length = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if(!stack.isEmpty()&& stack.peek()==s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= stack.size(); i++) {
            sb.append(stack.pop());
        }

//        return sb.reverse();

        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        System.out.println("g = " + g);






        Solution0022 solution0022 = new Solution0022();
        List<String> strings = solution0022.generateParenthesis1(3);
        System.out.println("strings = " + strings);
    }
    //如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
    public List<String> generateParenthesis1(int n){
        List<String> res = new ArrayList<>();

        backTrack(res, new StringBuilder() ,0 , 0,0,n);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder tempRes,int position , int open, int close, int n) {
        if(position == n*2){
            res.add(tempRes.toString());
        }else{
            if(open < n){
                tempRes.append("(");
                backTrack(res, tempRes, position+1, open+1, close,n);
                tempRes.deleteCharAt(position);
            }
            if(open > close){
                tempRes.append(")");
                backTrack(res, tempRes, position+1, open, close+1, n);
                tempRes.deleteCharAt(position);
            }
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
