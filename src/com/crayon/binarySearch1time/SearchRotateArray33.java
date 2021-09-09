package com.crayon.binarySearch1time;

public class SearchRotateArray33 {

    /**
     * TODO
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[0]) { // mid 在有序部分
                if (nums[mid] > target) { // target 在有序部分
                    right = mid - 1;
                } else {    // target 不在有序部分，在右边区间查找
                    left = mid + 1;
                }
            } else { // mid 在无序部分
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 1. 0,1,2,3,4,5,6
     * 2. 0     1
     * 3. 0     0
     * 4. 2,1   1
     * 5. 2,1   2
     *
     * O(n) + O(logn)
     */
    public int search2(int[] nums, int target) {
        if (nums[nums.length - 1] == target) return nums.length - 1;
        int i = 0;
        boolean rotate = false;
        for (;i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                rotate = true;
                break;
            }
        }
        int left = 0, right = i;
        if (nums[nums.length - 1] > target && rotate) {
            left = i + 1;
            right = nums.length - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
