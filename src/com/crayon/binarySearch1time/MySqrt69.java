package com.crayon.binarySearch1time;

public class MySqrt69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x;
        while (l <= r) { //0 , 8
            int mid = l + (r -l) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) r = mid - 1; // 4 * 4 > 8,r = 3 r = 2
            else l = mid + 1; // l = 2 l = 3
        }
        return r;
    }
}
