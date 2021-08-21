package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 395. 至少有K个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * 通过次数27,645提交次数56,273
 * @author zhuqi at 2021/2/27
 */
public class Solution0395 {

    public static void main(String[] args){
        String s = "hello world";
        System.out.println("s.substring(0,1000) = " + s.substring(0, s.length()+1));
        char cTemp ;
        int[] nums = new int[]{1,2,3,4,};
        List<Integer> lists = new ArrayList<>();
        List<?> a = lists;

    }

    public static int longestSubstring(String s, int k) {
        int length = s.length();
        int left=0, right = length-1;
        int result = 0;
        Map<Character, Integer> maps = new HashMap<>();
        while (left< right){
//            if ()

            right++;
        }


        return result;
    }


}
