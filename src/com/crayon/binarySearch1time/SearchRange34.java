package com.crayon.binarySearch1time;

public class SearchRange34 {

    int target1 = -1;
    public int[] searchRange(int[] nums, int target) {
        target1 = target;
        return new int[]{left(nums, 0, nums.length - 1, true), left(nums, 0, nums.length - 1, false)};
    }

    //[5,7,7,8,8,10] n = 6 target = 8
    public int left(int[] nums, int left, int right, boolean findleft) {
        // 0, 5 true
        // 0, 1 false
        if (left > right) return -1;
        // while (left <= right) {
        // 2
        // 0
        int mid = left + (right - left) / 2;
        if (nums[mid] == target1) {
            if (findleft) {
                if (mid == 0 || nums[mid - 1] != target1) return mid;
                return left(nums, left, mid - 1, findleft);
            } else {
                // 0 == 1 -> false 2 != 2
                if (mid == nums.length - 1 || nums[mid + 1] != target1) return mid;
                return left(nums, mid + 1, right, findleft);
            }
        } else if (nums[mid] > target1) return left(nums, left, mid - 1, findleft);
        else return left(nums, mid + 1, right, findleft);
        // }
    }
}
