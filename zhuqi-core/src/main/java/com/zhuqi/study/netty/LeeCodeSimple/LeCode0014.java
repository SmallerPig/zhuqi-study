package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/15
 */
public class LeCode0014 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flowe","flower","flower"};
        String s = longestCommonPrefix0(strs);
        System.out.println("strs = " + strs);
        System.out.println("s = " + s);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * XXXXXX 目前还未解决
     * 竖向扫描..
     * @param strs
     * @return
     */
    public static String longestCommonPrefix0(String[] strs) {
        int count = strs.length;
        if (count ==1){
            return strs[0];
        }else if (count ==0){
            return "";
        }
        int length = strs[0].length();
        for (int l = 0; l<length;l++){
            for (int c=1;c<count;c++){
                if (strs[c].length() == l || strs[c].charAt(l)!= strs[0].charAt(l) ){
                    System.out.println("c = " + c);
                    System.out.println("l = " + l);
                    return strs[0].substring(0, l);
                }
            }
        }
        return strs[0];

//        for (int i = 0; i < length; i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < count; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }



    }
}
