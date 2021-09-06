package com.crayon.sort;

public class OnSort2Time {

    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            int max_index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[max_index]) max_index = j;
            }
            int temp = nums[i];
            nums[i] = nums[max_index];
            nums[max_index] = temp;
        }
        return nums;
    }

    /**
     * 4,5,1,6,2,8,3
     * 5,4,1,6
     * 5,4,6,1,2,8,3
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1]  = temp;
                }
            }
        }
        return nums;
    }

    /**
     *
     * 从大到小排序
     * @param nums
     *
     * 4,5,1,6,2,8,3
     *
     * 8,9,4,3,2,9
     * 9,8,4
     * 8,6,5,4,3,2,1
     * @return nums[]
     */
    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] > nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }

    static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[] int1 = {3};
        int[] int2 = {3,4};
        int[] int3 = {3,1,9,10,3,6,8,55,2,34,6};
        int[] int4 = {1,2,3,4,5,6};
        int[] int5 = {6,5,4,3,23,3,3,1};
    }
}
