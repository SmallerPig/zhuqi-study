//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以
//决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 209 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarraySumWithOneDeletion().new Solution();
        int i = solution.maximumSum(new int[]{1, -2, 0, 3});
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 本题是典型的动态规划应用题，我们可以将问题拆分成多个子问题，即求解以 arr[i] 结尾的最多删除一次的非空子数组的最大和。
         * 我们以 dp[i][k] 表示以 arr[i] 结尾，删除 k 次的非空子数组的最大和
         * （删除前的末尾元素为 arr[i]，就视为以 arr[i] 结尾）。
         * 初始时 dp[0][0]=arr[0]，dp[0][1]＝0
         * （以 arr[0] 结尾，删除一次的非空子数组不存在，因此 dp[0][1] 不会计入结果）
         * > 2023/06/27 13:44:28
         * Success:
         * Runtime:5 ms, faster than 88.89% of Java online submissions.
         * Memory Usage:50.6 MB, less than 52.78% of Java online submissions.
         *
         * @param arr
         * @return
         */
        public int maximumSum(int[] arr) {
            int dp0 = arr[0], dp1 = 0, res = arr[0];
            for (int i = 1; i < arr.length; i++) {
                dp1 = Math.max(dp0, dp1 + arr[i]);
                dp0 = Math.max(dp0, 0) + arr[i];
                res = Math.max(res, Math.max(dp0, dp1));
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}