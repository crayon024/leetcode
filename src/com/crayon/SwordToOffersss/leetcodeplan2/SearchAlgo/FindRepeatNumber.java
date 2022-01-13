package com.crayon.SwordToOffersss.leetcodeplan2.SearchAlgo;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：
 * 2 <= n <= 100000
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * ps:
 * 它考察的是程序员的沟通能力，先问面试官要时间/空间需求！！！
 * 只是时间优先就用字典，
 * 还有空间要求，就用指针+原地排序数组，
 * 如果面试官要求空间O(1)并且不能修改原数组，还得写成二分法！！！
 *
 * 思路：
 * 1. 根据 n 长度，元素大小在 n-1 的特点，数组原地排序。
*/
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 2) throw new NullPointerException();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) continue;
            if (nums[nums[i]] == nums[i]) return nums[i];
            temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
            /*
             * ++
             * 用例[3,4,2,0,0,1] -> [0,0,2,3,4,1] i = 2 前两个 0 没有比较。
             * 更换位置后，再次比较一下，避免忽略之前换的数组.
             *
             * 或者改用 while 循环，只在 nums[i] == i 的时候才 i++。
             * 这样就不用补充下面这一句
             */
            if (nums[nums[i]] == nums[i]) return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length < 2) throw new NullPointerException();

        Set<Integer> only = new HashSet<>();
        for (int i : nums) {
            if (only.contains(i)) return i;
            else only.add(i);
        }
        return -1;
    }
}
