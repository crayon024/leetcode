package com.crayon;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * [3,2,4] 6
 */
public class TwoSum {

    /**
     * 两次遍历
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length, 1F);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // 重复元素覆盖问题 [2, 3, 2] 4
        }
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a) && map.get(a) != i) {
                return new int[] {map.get(a), i};
            }
        }
        return new int[-1];
    }

    /**
     * 一遍 hash , 元素不能重复使用,返回顺序没有限制 -> 可以直接先放元素
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length, 1F);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[-1];
    }
}
