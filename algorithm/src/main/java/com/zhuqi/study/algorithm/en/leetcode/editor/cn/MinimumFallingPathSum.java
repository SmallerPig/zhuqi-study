//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 259 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        int i = solution.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}});
//        int i = solution.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/07/13 14:44:09
         * Success:
         * Runtime:5 ms, faster than 37.82% of Java online submissions.
         * Memory Usage:43.4 MB, less than 12.65% of Java online submissions.
         *
         * @param matrix
         * @return
         */
        public int minFallingPathSum(int[][] matrix) {
            int ans = Integer.MAX_VALUE;
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < m; i++) {
                int[] column = matrix[i];
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
                dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
                for (int j = 1; j < n - 1; j++) {
                    int preMin = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                    dp[i][j] = preMin + matrix[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dp[m - 1][i]);
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}