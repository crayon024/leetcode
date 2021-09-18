package com.crayon.binarySearch1time;

public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_num = matrix[mid][0];
            if (mid_num > target) right = mid - 1;
            else if (mid_num < target) {
                if (target <= matrix[mid][matrix[mid].length - 1]) {
                    for (int i = 0; i < matrix[0].length; i++) {
                        if (matrix[mid][i] == target) return true;
                    }
                    return false;
                } else left = mid + 1;
            } else return true;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int level_length = ints.length;
            int level_max = ints[level_length - 1];
            if (target <= level_max) { // 就在这一层
                for (int j = level_length - 1; j >= 0; j--) {
                    if (target == ints[j]) return true;
                }
            }
        }
        return false;
    }
}