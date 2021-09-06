package com.crayon.binarySearch1time;

public class SearchInsert35 {

    /**
     * 1,3,5,6   2
     * 0 + 3 / 2 = 1   right = 2
     * 0 + 2 / 2 = 1  right = 1
     * 0 + 1 / 2 = 0  right = -1 should return 1
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        boolean inRight = false;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                inRight = true;
                right = mid - 1;
            }
            else {
                inRight = false;
                left = mid + 1;
            }
        }
        return inRight ? mid: mid + 1;

    }
}
