package com.zhuqi.study.netty.LeeCodeSimple;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = " "
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * 通过次数158,368提交次数463,373
 * @author zhuqi at 2021/2/18
 */
public class LeCode0058 {

    public static void main(String[] args) {
        LeCode0058 leCode0058 = new LeCode0058();
        int resu = leCode0058.lengthOfLastWord1("hello world");
        System.out.println("resu58 = " + resu);
    }

    public int lengthOfLastWord0(String s) {
        if (s.isEmpty()){
            return 0;
        }
        String[] array = s.split(" ");
        return array[array.length-1].length();

    }
    public int lengthOfLastWord1(String s) {
        char[] chars = s.toCharArray();
        int last =0;
        int result =0;
        for (char c : chars){
            if (c==' '){
                last =0;
                continue;
            }
            last++;
            result =last;
        }
        return last==0?result:last;


    }
}
