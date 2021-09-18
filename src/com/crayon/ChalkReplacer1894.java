package com.crayon;

/**
 * 模拟
 * // 提示：
 * //
 * //
 * // chalk.length == n
 * // 1 <= n <= 105
 * // 1 <= chalk[i] <= 105
 * // 1 <= k <= 109
 */
public class ChalkReplacer1894 {

    /**
     * 模拟
     * 注意迭代+ 的时候的 int 溢出问题
     */
    public int chalkReplacer(int[] chalk, int k) {
        long one_total = 0;
        // 10^10 2^32 10000000000
        for(int c : chalk) one_total += c;

        // 22 % 11 = 0
        // 25 % 10 = 5
        // 33 % 10000000000 =
        int last = (int) (k % one_total); // 最后一个学生消耗完剩下多少粉笔

        // k < one_total  [5,1,5] 6 last = 6

        //[1] 1
        for (int i = 0; i < chalk.length; i++) {
            last -= chalk[i];
            if (last < 0) return i;
        }

        return -1;
    }

    /**
     * 暴力
     */
    public int chalkReplacer2(int[] chalk, int k) {
        while(true) {
            for (int i = 0; i < chalk.length; i++) {
                k = k - chalk[i];
                if ( k < 0 ) return i;
            }
        }
//        return -1; here
    }
}
