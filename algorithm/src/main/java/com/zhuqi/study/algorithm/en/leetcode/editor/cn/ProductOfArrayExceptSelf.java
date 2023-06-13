//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
//
// Related Topics 数组 前缀和 👍 1413 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
//        int[] ints = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/13 18:44:08
         * Success:
         * Runtime:1 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:49.6 MB, less than 68.49% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;

            // L 和 R 分别表示左右两侧的乘积列表
            int[] L = new int[length];
            int[] R = new int[length];
            L[0] = 1;
            R[length - 1] = 1;

            int[] ans = new int[length];

            for (int i = 1; i < length; i++) {
                L[i] = L[i - 1] * nums[i - 1];
//                System.out.println("i = " + i);
//                System.out.println("L[i] = " + L[i]);
            }
            for (int i = length - 2; i >= 0; i--) {
                R[i] = R[i + 1] * nums[i + 1];
//                System.out.println("i = " + i);
//                System.out.println("R[i] = " + R[i]);
            }

            for (int i = 0; i < length; i++) {

                ans[i] = L[i] * R[i];
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}