package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * 通过次数48,154提交次数62,571
 * @author zhuqi at 2021/2/24
 */
public class Solution0832 {


    public static void main(String[] args){
        Solution0832 solution0832 = new Solution0832();
        System.out.println("solution0832.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}) = " + solution0832.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i] = invert(flip(A[i]));
        }

        return result;

    }

    /**
     * 反转
     * @param nums
     * @return
     */
    int[] invert(int[] nums){
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = nums[i]==0?1:0;
        }
        return result;
    }

    /**
     * 水平翻转
     * @param nums
     * @return
     */
    int[] flip(int[] nums){
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = nums[length-i-1];
        }
        return result;
    }


    /*
     * [2,2,1]
     * [4,1,2,1,2]
     */
    public int singleNumber(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> resultList = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (resultList.containsKey(nums[i])){
                resultList.remove(nums[i]);
            }else{
                resultList.put(nums[i],1);
            }
        }
        return resultList.getOrDefault(0,0);
    }

}
