package com.crayon.SwordToOffersss;
/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 0 <= n <= 100
 *
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 */
public class Fibonacci {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;


        int x = fib(n-1) + fib(n - 2);
        return x%(1^9+7);
    }

    // int 类型溢出 ...
    public int fib2(int n) {
        if (n == 0 || n == 1) return n % (1^9+7);

        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            sum = a + b; // 1 2
            a = b; // 1  1
            b = sum; // 1 2
        }
        return sum % (1^9+7);
    }
}
