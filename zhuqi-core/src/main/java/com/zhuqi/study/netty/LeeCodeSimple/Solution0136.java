package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.*;

/**
 * @author zhuqi at 2021/2/24
 */
public class Solution0136 {


    public static void main(String[] args){
        Solution0136 solution0136 = new Solution0136();
        System.out.println("solution0136.singleNumber(new int[]{2,2,1}) = " + solution0136.singleNumber(new int[]{2, 2, 1}));
    }
    public int singleNumber(int[] nums) {
        int length = nums.length;
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < length; i++) {

            if (! sets.add(nums[i])){
                sets.remove(nums[i]);
            }
        }
        return sets.iterator().next();
    }



    public boolean isUgly(int num) {
        if (num ==1){return true;}
        int[] uglys = new int[]{2,3,5};
        for (int i = 0; i < 3; i++) {
            if (num % uglys[i]==0){
                boolean ugly = isUgly(num / uglys[i]);
                if (ugly){
                    return true;
                }
            }
        }
        return false;
    }

}
