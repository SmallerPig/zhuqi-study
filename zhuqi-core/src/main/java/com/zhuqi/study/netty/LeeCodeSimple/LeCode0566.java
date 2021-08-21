package com.zhuqi.study.netty.LeeCodeSimple;

import sun.security.util.Length;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 *
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 * 通过次数33,474提交次数49,152
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/17
 */
public class LeCode0566 {

    public static void main(String[] args) {
        int[][] nums = new int[4][4];
        int r = 3;
        int c= 4;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = i+j;
            }
        }

        LeCode0566 leCode0566 = new LeCode0566();
        leCode0566.matrixReshape(nums,r,c);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int l1 = nums.length;
        if (l1 * nums[0].length != r*c ){
            return nums;
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = queue.poll();
            }
        }
        return result;
    }

    /**
     * 官方解答,确实比我的方法要牛逼很多
     *
     *
     * 那么题目需要我们做的事情相当于：
     *
     * 将二维数组 \textit{nums}nums 映射成一个一维数组；
     *
     * 将这个一维数组映射回 rr 行 cc 列的二维数组。
     *
     * 我们当然可以直接使用一个一维数组进行过渡，但我们也可以直接从二维数组 \textit{nums}nums 得到 rr 行 cc 列的重塑矩阵：
     *
     * 设 \textit{nums}nums 本身为 mm 行 nn 列，如果 mn \neq rcmn
     * 
     * ​
     *  =rc，那么二者包含的元素个数不相同，因此无法进行重塑；
     *
     * 否则，对于 x \in [0, mn)x∈[0,mn)，第 xx 个元素在 \textit{nums}nums 中对应的下标为 (x ~/~ n, x~\%~ n)(x / n,x % n)，而在新的重塑矩阵中对应的下标为 (x ~/~ c, x~\%~ c)(x / c,x % c)。我们直接进行赋值即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reshape-the-matrix/solution/zhong-su-ju-zhen-by-leetcode-solution-gt0g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshapeOrg(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

}
