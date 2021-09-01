package com.crayon.linkedlist2time;

import com.crayon.ListNode;

/**
 * f    s
 * 1 -> 2 -> 3 -> 4
 *
 * second  pre      first
 * 2        1      3       4
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode first = head, second = null, result = pre;

        // 这一句没有必要，因为第一次循环，pre.next 指向 second, result 就指向了结果
//        result.next = (first != null && first.next != null) ? first.next : first;

        while (first != null && (second = first.next) != null) {
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
        }
        return result.next;
    }
}
