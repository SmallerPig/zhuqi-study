package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.Arrays;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 通过次数294,274提交次数741,206
 * @author zhuqi at 2021/2/17
 */
public class LeCode0028 {

    public static void main(String[] args) {
        LeCode0028 leCode0028 = new LeCode0028();
        int res = leCode0028.strStr("c", "c");
        System.out.println("res = " + res);
    }

    public int strStr(String haystack, String needle) {

        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0; i < l1; i++) {
            if (i+l2 <= l1 &&haystack.substring(i,i+l2).equals(needle) ){
                return i;
            }
        }
        return -1;


//        这个算法的问题在于指针i一直不变,导致一直返回-1
//        for (int i = 0; i < l1; i++) {
//            for (int j = 0; j < l2; j++) {
//                if (haystack.charAt(i) == needle.charAt(j)){
//                    continue;
//                }
//                if (j == l2-1){
//                    return i;
//                }
//                break;
//            }
//        }
    }
}
