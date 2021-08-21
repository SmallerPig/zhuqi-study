package com.zhuqi.study.netty.LeeCodeMiddle;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * @author zhuqi at 2021/3/2
 */
public class Solution0304 {

    public static void main(String[] args) {
        Solution0304 solution0304 = new Solution0304(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });
        System.out.println(solution0304.sumRegion(2, 1, 4, 3));
        System.out.println(solution0304.sumRegion(1, 1, 2, 2));
        System.out.println(solution0304.sumRegion(1, 2, 2, 4));


    }

    int[][] sum;

    public Solution0304(int[][] matrix) {

        int m = matrix.length;
        if (m >0){
            int n = matrix[0].length;
            sum = new int[m][n];
            for (int i = 0; i < m; i++) {
                int tempSum =0;
                int[] tempSums = new int[n];
                for (int j = 0; j < n; j++) {
                    tempSum = tempSum+matrix[i][j];

                    tempSums[j] = tempSum;
                }
                sum[i] = tempSums;
            }
        }

    }
    // 2,1,4,3
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result =0;
        for (int i = row1; i <= row2; i++) {
            System.out.println("i = " + i);

            int firstNum = col1==0?0:sum[i][col1-1];
            int secendNum = sum[i][col2];
            System.out.println("secendNum = " + secendNum);

            result = result+ secendNum-firstNum;
            System.out.println("result = " + result);

        }

        return result;
    }
}
