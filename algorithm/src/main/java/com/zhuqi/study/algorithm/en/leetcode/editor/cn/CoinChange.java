//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2400 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * > 2023/04/18 20:26:43
         * Success:
         * Runtime:16 ms, faster than 32.22% of Java online submissions.
         * Memory Usage:41 MB, less than 55.53% of Java online submissions.
         * <p>
         * 重点是Arrays.fill(dp, amount+1)
         * 为啥不填充Integer.MIN_VALUE? 因为这样在比较Math.min的时候永远不会拿到正确的值,只会返回MIN_VALUE
         * 为啥不填充Integer.MAX_VALUE?
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {

                for (int coin : coins) {
                    if (coin > i) {
                        continue;
                    }
                    if (coin == i) {
                        dp[coin] = 1;
                        break;
                    }
                    if (dp[i - coin] != Integer.MIN_VALUE) {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
                //System.out.println("dp[i] = " + dp[i]);

            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}