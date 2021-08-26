package com.crayon.SwordToOffersss;

import java.util.Objects;

/**
 * 剑指 Offer 03. 数组中重复的数字 <br/>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/ <br/>
 * <br/>
 * 找出数组中重复的数字。 <br/>
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <br/>
 * 2 <= n <= 100000
 */

public class FindRepeatNumber {

    // O(n) O(1),原地比较，利用数组元素的值范围不超过数组长度。
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int x = nums[i];
            if (x == i) {
                i++;
                continue;
            }
            if (nums[x] == nums[i]) {
                return nums[x];
            }
            int temp = nums[x];
            nums[x] = x;
            nums[i] = temp;
        }
        return -1;
    }

    // 直接利用一个辅助的数组,利用下标判断是否重复
    // 还有一种方式是利用 Map/Set
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
//            return ;
        }

        int[] dup = new int[nums.length];
        // 避免默认值 0 的问题
        dup[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (dup[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                dup[nums[i]] = nums[i];
            }
        }
        return -1;
    }


    /* 比较巧妙的地方在于 nums[i] == i，先让数组元素进行归位
       归位的时候判断索引上的值是否重复来判断以及进行交换操作
    */
    public int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
//            return ;
        }
        int[] copy = new int[nums.length];
        copy[0] = -1;
        for (int x : nums) {
            if (copy[x] == x) {
                return x;
            }
            copy[x] = x;
        }
        return -1;
    }
}
