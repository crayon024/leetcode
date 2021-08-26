package com.crayon.sort;

public class OnSort {


    /**
     * [5,7,3,2] length = 4
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) return nums;
        }
        return nums;
    }
    /**
     * [5,4,7,2] length = 4
     * [5, ,4,2]
     * [ ,5,4,2]
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从大到小排序
        for (int i = 1; i < nums.length; i++) {
            int unsortedNum = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (unsortedNum <= nums[j]) {
                    break;
                } else {
                    nums[j + 1] = nums[j];
                }
            }
            nums[j] = unsortedNum;
        }
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int maxIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{};
        int[] num1 = new int[]{1,2,3,4,5};
        int[] num2 = new int[]{5,2,6,7,7,79,25,36,45};
        int[] num3 = new int[]{5,4,4,2,1};
        int[] num4 = new int[]{1};
        int[] num5 = new int[]{2,1};
        int[] num6 = new int[]{2,1,7};
    }
}
