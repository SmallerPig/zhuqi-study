//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。 
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 43 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        Solution solution = new EqualRowAndColumnPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/06 11:02:08
         * Success:
         * Runtime:31 ms, faster than 62.58% of Java online submissions.
         * Memory Usage:49.6 MB, less than 30.58% of Java online submissions.
         *
         * @param grid
         * @return
         */
        public int equalPairs(int[][] grid) {
            int length = grid.length;
            int[][] rows = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    rows[i][j] = grid[j][i];
                }
            }

            int ans = 0;
            for (int[] ints : grid) {
                for (int j = 0; j < length; j++) {
                    if (check(ints, rows[j])) {
                        ans++;
                    }
                }
            }
            return ans;
        }


        public boolean check(int[] n1, int[] n2) {
            int length = n1.length;
            for (int i = 0; i < length; i++) {
                if (n1[i] != n2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}