package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 通过次数151,517提交次数216,646
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuqi at 2021/2/22
 */
public class Solution0118 {

    public static void main(String[] args){
        Solution0118 solution0118 = new Solution0118();
        List<List<Integer>> res1 = solution0118.generate(5);
        System.out.println("res1 = " + res1);

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> nums = new ArrayList<Integer>();

            for (int j = 1; j <= i; j++) {
                if (j==1|| j==i){
                    nums.add(1);
                }else{
                    nums.add(result.get(i-2).get(j-2) + result.get(i-2).get(j-1));
                }
            }
            result.add(nums);
        }
        return result;

    }
}
