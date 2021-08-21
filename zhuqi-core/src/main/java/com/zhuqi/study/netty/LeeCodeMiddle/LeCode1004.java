package com.zhuqi.study.netty.LeeCodeMiddle;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 * @author zhuqi at 2021/2/19
 */
public class LeCode1004 {

    public static void main(String[] args) {
        LeCode1004 leCode1004 = new LeCode1004();
//        int res = leCode1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        int res = leCode1004.longestOnes1(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        System.out.println("res = " + res);
    }

    public int longestOnes(int[] A, int K) {
        int length = A.length;
        int result = 0;
        //记录每个指针下的翻转次数
        int temp = 0;
        //当前指针下的最大值
        int max = 0;
        //右指针
        int index =0;
        // i代表当前数组当前所在位置指针
        for (int i = 0; i < length; i++) {
            //记录每个指针下的翻转次数
            temp = 0;
            //当前指针下的最大值
            max = 0;
            //右指针
            index =i;
            //还有翻转次数,或者当前指针的数字为1
            while (index<length && (temp < K||  A[index]==1)){
                //当前数字不是1,需要减一次翻转次数
                if (A[index]!=1){
                    temp++;
                }
                //当前指针下的最大值+1
                //当前指针下的又指针+1
                max++;
                index++;
            }
            result = Math.max(result, max);
        }
        return result;
    }


    public int longestOnes1(int[] A, int K) {
        int length = A.length;
        // 定义指针left
        int left = 0;
        // 保存最大的结果
        int result = 0;
        // 计数器count
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(A[i]==0){
                count++;
            }
            while (count > K){
                if(A[left]==0){
                    count--;
                }
                left++;
            }
            // 计算当前窗口的最大值 和原最大值比较
            result = Math.max(result,i-left+1);
        }
        return result;
    }
}
