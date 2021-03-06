package com.crayon.search;

/**
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 0,right = x, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                result = left;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return result;
    }
}
