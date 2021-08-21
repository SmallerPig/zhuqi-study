package com.zhuqi.study.netty.LeeCodeSimple;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 通过次数250,598提交次数550,103
 * @author zhuqi at 2021/2/18
 */
public class LeCode0066 {
    public static void main(String[] args) {
        LeCode0066 leCode0066 = new LeCode0066();
        int[] res = leCode0066.plusOne(new int[]{8, 9, 9, 9, 9, 9});
        for (int re: res){
            System.out.println(re);
        }
    }


    /**
     * 主要需要考虑9,9,9,9的情况
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int length = digits.length, sum = 0;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            sum = (sum*10 + digits[i]);
        }
        // plus one
        sum+=1;
        System.out.println("sum = " + sum);
        int index =0;
        while (sum>0){
            result[length-index-1]=sum%10;
            sum = sum/10;
            index++;
        }



        return result;
    }


    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

}
