package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 通过次数75,955提交次数98,552
 * @author zhuqi at 2021/3/3
 */
public class Solution0338 {

    public static void main(String[] args) {
        int res = 8&7;
        System.out.println("res = " + res);
//        System.out.println("8&7 = " + 8 & 7);
        int x =8;
        x &=(x-1);
        System.out.println("x = " + x);


        Lock lock = new ReentrantLock();
        lock. lock();
        try {
            System. out. println("获得锁");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System. out. println("释放锁");
            lock. unlock();
        }

    }


//    public int[] countBits(int num) {
//
//        for (int i = 0; i < num; i++) {
//            byte b = new Integer(i).byteValue();
//
//        }
//    }


    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

}
