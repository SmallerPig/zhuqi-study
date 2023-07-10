//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1436 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        int i = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        
        /**
         * > 2023/07/10 19:33:11
         * Success:
         * Runtime:13 ms, faster than 60.18% of Java online submissions.
         * Memory Usage:41.7 MB, less than 60.03% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int length = nums.length, ans = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < length - 2; i++) {
                int left = i + 1, right = length - 1;
                while (right > left) {

                    int tempSum = nums[i] + nums[left] + nums[right];

                    if (Math.abs(target - tempSum) < Math.abs(ans - target)) {
                        ans = tempSum;
                    }


                    if (tempSum < target) {
                        left++;
                    } else if (tempSum > target) {
                        right--;
                    } else {
                        return ans;
                    }

                }


            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}