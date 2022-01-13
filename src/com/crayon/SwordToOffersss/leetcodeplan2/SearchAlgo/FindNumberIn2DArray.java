package com.crayon.SwordToOffersss.leetcodeplan2.SearchAlgo;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * 1. 以为做过了就没有仔细思考。只考虑到右上角元素的上下剔除。就写下了代码...
 * 思路：
 * 1. 暴力法
 * 2. 从右上角元素开始。根据数据的递增顺序，依次排除列和行。
 *    退出条件在于 行和列的位置。
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // [[1,2,3]] 的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int i = 0, j = matrix[0].length - 1;
        while (true) {
            if (i > matrix.length - 1 || j < 0) return false;
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
    }
}
