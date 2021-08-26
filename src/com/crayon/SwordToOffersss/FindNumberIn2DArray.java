package com.crayon.SwordToOffersss;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。<br/>
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。<br/>
 *
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * <br/>
 * 示例:
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target 5，返回true。
 * 给 target 20，返回false。
 *
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */

public class FindNumberIn2DArray {
    /*
     * 1. 变量命令应该更可读 i -> col,j -> row
     * 2. while 进入条件 -  导致的越界问题
     * 3. 测试用例不够周全，比如 {{2}}，2 导致返回错误
     * 4. continue; 语句的不必要使用....
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }


        int i = matrix[0].length - 1;
        int j = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[j][i] > target) {
                i--;
//                continue;
            } else if (matrix[j][i] < target) {
                j++;
//                continue;
            } else {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = new int[][]{
                {1, 4, 7, 11,15},
                {2, 5, 8, 12,19},
                {3, 6, 9, 16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        int[][] matrix2 = new int[][]{{1}};
        System.out.println(matrix[0].length);

        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix2, 1));
    }
}
