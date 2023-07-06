//给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。 
//
// 
// 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 +
// 6) 和 (4 + 8) 。它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分
//出来的整数必须互不相同。 
// 
//
// 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返
//回这些整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：finalSum = 12
//输出：[2,4,6]
//解释：以下是一些符合要求的拆分：(2 + 10)，(2 + 4 + 6) 和 (4 + 8) 。
//(2 + 4 + 6) 为最多数目的整数，数目为 3 ，所以我们返回 [2,4,6] 。
//[2,6,4] ，[6,2,4] 等等也都是可行的解。
// 
//
// 示例 2： 
//
// 
//输入：finalSum = 7
//输出：[]
//解释：没有办法将 finalSum 进行拆分。
//所以返回空数组。
// 
//
// 示例 3： 
//
// 
//输入：finalSum = 28
//输出：[6,8,2,12]
//解释：以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
//(6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
//[10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= finalSum <= 10¹⁰ 
// 
//
// Related Topics 贪心 数学 回溯 👍 58 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
    public static void main(String[] args) {
        Solution solution = new MaximumSplitOfPositiveEvenIntegers().new Solution();
        List<Long> longs = solution.maximumEvenSplit(20);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这一题被一开始的回溯标签给误导了,看了答案之后发现用数学就可以直接解决这个问题,思路清晰牛逼
         * > 2023/07/06 15:22:14
         * Success:
         * Runtime:9 ms, faster than 97.96% of Java online submissions.
         * Memory Usage:54 MB, less than 69.39% of Java online submissions.
         *
         * @param finalSum
         * @return
         */
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> res = new ArrayList<>();
            if (finalSum % 2 > 0) {
                return res;
            }
            for (long i = 2; i <= finalSum; i += 2) {
                res.add(i);
                finalSum -= i;
            }
            // 把最后一个数和finalSum相加,就是最后想要的结果了
            res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}