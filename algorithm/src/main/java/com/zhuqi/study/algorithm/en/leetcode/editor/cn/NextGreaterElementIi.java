//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 823 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] ints = solution.nextGreaterElements(new int[]{2, 1, 2, 4, 3});
        System.out.println("ints = " + ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/06/28 18:59:55
         * Success:
         * Runtime:90 ms, faster than 5.15% of Java online submissions.
         * Memory Usage:44.4 MB, less than 5.11% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int[] nextGreaterElements(int[] nums) {
            int length = nums.length;
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                int cur = -1;
                for (int j = i + 1; j < length + i; j++) {
                    if (nums[j % length] > nums[i]) {
                        cur = nums[j % length];
                        break;
                    }
                }
                ans[i] = cur;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}