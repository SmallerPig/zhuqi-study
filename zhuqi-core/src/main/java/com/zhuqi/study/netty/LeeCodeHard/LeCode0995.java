package com.zhuqi.study.netty.LeeCodeHard;

/**
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 * 通过次数3,733提交次数8,111
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/18
 */
public class LeCode0995 {

    public static void main(String[] args) {
        LeCode0995 leCode0995 = new LeCode0995();
        System.out.println(0 ^ 1);


        int res = leCode0995.minKBitFlips0(new int[]{1,0,1}, 3);
//        int res = leCode0995.minKBitFlips0(new int[]{0,0,0,1,0,1,1,0}, 3);
//        int res = leCode0995.minKBitFlips0(new int[]{1, 0, 1, 1}, 2);
        System.out.println("res = " + res);
    }


    /**
     * 方法一：差分数组
     * 由于对同一个子数组执行两次翻转操作不会改变该子数组，所以对每个长度为 KK 的子数组，应至多执行一次翻转操作。
     *
     * 对于若干个 KK 位翻转操作，改变先后顺序并不影响最终翻转的结果。不妨从 A[0]A[0] 开始考虑，若 A[0]=0A[0]=0，则必定要翻转从位置 00 开始的子数组；若 A[0]=1A[0]=1，则不翻转从位置 00 开始的子数组。
     *
     * 按照这一策略，我们从左到右地执行这些翻转操作。由于翻转操作是唯一的，若最终数组元素均为 11，则执行的翻转次数就是最小的。
     *
     * 用 NN 表示数组 AA 的长度。若直接模拟上述过程，复杂度将会是 O(NK)O(NK) 的。如何优化呢？
     *
     * 考虑不去翻转数字，而是统计每个数字需要翻转的次数。对于一次翻转操作，相当于把子数组中所有数字的翻转次数加 11。
     *
     * 这启发我们用差分数组的思想来计算当前数字需要翻转的次数。我们可以维护一个差分数组 \textit{diff}diff，其中 \textit{diff}[i]diff[i] 表示两个相邻元素 A[i-1]A[i−1] 和 A[i]A[i] 的翻转次数的差，对于区间 [l,r][l,r]，将其元素全部加 11，只会影响到 ll 和 r+1r+1 处的差分值，故 \textit{diff}[l]diff[l] 增加 11，\textit{diff}[r+1]diff[r+1] 减少 11。
     *
     * 通过累加差分数组可以得到当前位置需要翻转的次数，我们用变量 revCntrevCnt 来表示这一累加值。
     *
     * 遍历到 A[i]A[i] 时，若 A[i]+\textit{revCnt}A[i]+revCnt 是偶数，则说明当前元素的实际值为 00，需要翻转区间 [i,i+K-1][i,i+K−1]，我们可以直接将 \textit{revCnt}revCnt 增加 11，\textit{diff}[i+K]diff[i+K] 减少 11。
     *
     * 注意到若 i+K>ni+K>n 则无法执行翻转操作，此时应返回 -1−1。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                diff[i + K] ^= 1;
            }
        }
        return ans;

    }


    /**
     *  * 输入：A = [0,0,0,1,0,1,1,0], K = 3
     *  * 输出：3
     *  * 解释：
     *  * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
     *  * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
     *  * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
     *
     *
     *  A = [0,1,0], K = 1
     *
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips0(int[] A, int K) {
        int result =0;
        int length = A.length;
        if (length<K){
            return -1;
        }
        if (length==K){

        }
        for (int i = 0; i <= length-K; i++) {
            if (A[i]==0){
                for (int j = 0; j < K; j++) {
                    A[i+j] = A[i+j]^1;
                }
                result++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (A[i]==0){
                return -1;
            }
        }

        return result;

    }
}
