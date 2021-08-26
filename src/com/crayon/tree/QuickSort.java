package com.crayon.tree;

public class QuickSort {

    private void partition(int[] nums, int left, int right) {
        int benchMark = nums[left];

        while (left < right) {
            int j = right;
            int i = left;
            while (i < j && nums[j] < benchMark) {
                j--;
            }

        }
    }
}
