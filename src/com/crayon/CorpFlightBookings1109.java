package com.crayon;

/**
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）
 * 的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *  
 * 示例 1：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 *
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 *
 */
public class CorpFlightBookings1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            result[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) result[bookings[i][1]] -= bookings[i][2];
        }

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }

    // 暴力侥幸解法
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] result = new int[n];
        int list = bookings.length;
        for (int i = 0; i < list; i++) {
            for (int j = bookings[i][0] - 1; j < bookings[i][1]; j++) {
                result[j] += bookings[i][2];
            }
        }
        return result;
    }
}
