package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @author zhuqi at 2021/3/7
 */
public class Solution0131 {

    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            List<String> ret = new ArrayList<>();
            for (int j = i; j < length; j++) {
                String tem = s.substring(i,j);
                StringBuilder stringBuilder = new StringBuilder(tem);
                String s1 = stringBuilder.reverse().toString();
                if(s1.equals(tem)){
                    ret.add(tem);
                }
            }
            if(!ret.isEmpty()){
                result.add(ret);

            }
        }
        return result;

    }
}
