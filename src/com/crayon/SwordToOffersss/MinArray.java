package com.crayon.SwordToOffersss;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <br>
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */

public class MinArray {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // numbers[mid] == numbers[right]
//                int i = mid, min = numbers[mid]; {0,2,2,2,2,2}
                int i = left, min = numbers[i];

                while (i < right) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                    i++;
                }
                return min;
            }
        }
        return numbers[left];
    }

    // O(n) 遍历法
    public int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int i = numbers.length - 1;
        while (i > 0) {
            if (numbers[i] < numbers[i - 1]) {
                break;
            }
            i--;
        }
        return numbers[i];
    }
}
