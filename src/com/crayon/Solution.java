package com.crayon;

/**
 *
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。

 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 *
 * 提示：
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 */
public class Solution {
    int sum;
    public Solution(int[] w) {
        for (int i : w) {
            sum++;
        }
    }

    public int pickIndex() {

        return -1;
    }
}
