package com.crayon;

import java.util.Arrays;

public class FindMaximizedCapital502 {

    /**
     * TODO
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int[][] projectAndBegin = new int[n][2];
        for (int i = 0; i < n; i++) {
            projectAndBegin[i][0] = capital[0];
            projectAndBegin[i][1] = profits[0];
        }
        /*
          {0,1}
          {1,2}
          {1,3}
         */

        Arrays.sort(projectAndBegin);
        for (int i = 0; i < k; i++) {
//            while (projectAndBegin[i][0] <= w)
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] projectAndBegin = {
                                    {0, 6},
                                    {1, 10},
                                    {3, 2},
                {2, 7}
        };
        Arrays.sort(projectAndBegin, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.toString(projectAndBegin));
    }
}
