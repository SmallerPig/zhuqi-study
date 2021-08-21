package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *
 * 示例 1：
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 *
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 *
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * 通过次数190,627提交次数331,745
 * @author zhuqi at 2021/2/20
 */
public class LeCode0167 {

    public static void main(String[] args) {
        LeCode0167 leCode0167 = new LeCode0167();
//        int[] sum1 = leCode0167.towSum0(new int[]{2,7,11,15}, 9);//1,2
//        System.out.println("sum1 = " + sum1);
//        int[] sum2 = leCode0167.towSum0(new int[]{2,3,4}, 6);//1,3
//        System.out.println("sum2 = " + sum2);
//        int[] sum3 = leCode0167.towSum0(new int[]{-1,0}, -1);//1,2
//        System.out.println("sum3 = " + sum3);
//        int[] sum4 = leCode0167.towSum0(new int[]{5, 25,75}, 100);//2,3
        int[] sum5 = leCode0167.towSum0(new int[]{1,2,3,4,4,8,90}, 8);//4,5
//        System.out.println("sum4 = " + sum4);
        System.out.println("sum5 = " + sum5);
    }

    public int[] towSum0(int[] numbers, int target){
        int length = numbers.length;
        for (int i = 0; i < length-1; i++) {
            int num = numbers[i];
            int left = i+1, rigth = length-1;
            while (left<= rigth){
                int mid = left +(rigth-left)/2;
                if (numbers[mid] == target-num){
                    return new int[]{i+1, mid+1};
                }else if(numbers[mid] > target-num){
                    rigth = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }



    public int[] twoSum(int[] numbers, int target) {
        int[] result= new int[2];

        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int[] resources = new int[length-i-1];
            for (int j = 0; j < length - i - 1; j++) {
                resources[j] = numbers[i+j+1];
            }
            int targert = findTargert(resources, target - numbers[i]);
            if (targert>-1){
                return new int[]{i+1, i+targert+2};
            }
        }
        return result;
    }

    int findTargert(int[] nums, int target){
        int left = 0, right = nums.length-1;
        if (nums.length == 1 && nums[0]==target){
            return 0;
        }
        while (left<=right){
            int mid = (right-left)/2 +left;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
