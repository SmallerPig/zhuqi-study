package com.zhuqi.study.netty.LeeCodeSimple;

/**
 *
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 * 通过次数80,136提交次数189,938
 * @author zhuqi at 2021/2/20
 */
public class LeCode0278 {

    public static void main(String[] args){
        LeCode0278 leCode0278 = new LeCode0278();
        int res = leCode0278.firstBadVersion(100);
        System.out.println("res = " + res);

    }

    /**
     * 1,2,3,[4,5]
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0, right = n, result =right;
            while (left<= right) {
                int mid = left + (right-left)/2;
                System.out.println("mid = " + mid);
                boolean isMidBadVersion = isBadVersion(mid);

                if (!isMidBadVersion) {
                    left = mid + 1;
                    result = mid;
                } else {
                    right = mid - 1;
                }
            }
        return result+1;
    }

    boolean isBadVersion(int version){
        return version>=89;
    }
}
