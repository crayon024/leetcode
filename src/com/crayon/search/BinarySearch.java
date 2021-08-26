package com.crayon.search;

public class BinarySearch {
    /*
     * 变体问题,查找最后一个小于等于给定值的元素
     * 1,2,3,4,5,5,6,8,8,9 -> 6  return 第二个 5
     */
    public int binarySearch4(int[] nums, int value) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= value) {
                if (mid == nums.length - 1 || nums[mid + 1] > value) return mid;
                else left = mid + 1;
            } else {
                // nums[mid] > value
                right = mid - 1;
            }
        }
        return -1;
    }


    /*
     * 变体问题,查找第一个大于等于给定值的元素
     * 1,2,3,4,8,8,9 -> 5  return 8
     */
    public int binarySearch3(int[] nums, int value) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= value) {
                if (mid == 0 || nums[mid - 1] < value) return nums[mid];
                else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    /*
     * 变体问题,查找最后一个等于给定值的元素
     * 1,2,2,2,3,4
     */
    public boolean binarySearch2(int[] nums, int value) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == value) {
                if (mid == nums.length - 1 || nums[mid + 1] != value) return true;
                else right = mid - 1;
            } else if (value > nums[mid]) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }

    /*
     * 变体问题,查找第一个等于给定值的元素
     * 1,2,2,2,3,4
     */
    public boolean binarySearch1(int[] nums, int value) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == value) {
                if (mid == 0 || nums[mid - 1] != value) return true;
                else right = mid - 1;
            } else if (value > nums[mid]) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int value) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            /*
             *  这么写的目的是避免下标加起来过大导致溢出
             *  但是问题在于提前进行 / 会舍弃小数点的部分导致问题
             *  参数化测试时,{[1,2],2} 无限循环
             *  int mid = left/2 + right/2;
             *
             */
            int mid = (left + right) / 2;
            if (value == nums[mid]) {
                return true;
            } else if (value > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


}
