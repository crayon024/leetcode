package com.crayon.SwordToOffersss;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 */
public class StairsJumpWays {


    public int numWays(int n) {
        if (n == 0) return 0;

        if (n == 1 || n == 2) return n;

        int a = 1;

        for (int i = 2; i < n; i++) {

        }
        return 1;
    }
}
