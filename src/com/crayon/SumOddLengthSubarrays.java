package com.crayon;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 */
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            for (int j = i; j < 2; j += 2) {
                sum += arr[j];
            }
        }

        return -1;
    }
}
