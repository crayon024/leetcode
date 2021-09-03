package com.crayon.linkedlist1time;

import com.crayon.ListNode;

public class InsertionSortList147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1), biggest = head, cur = head.next, pre = dummy;
        dummy.next = head;

        while (cur != null) {
            if (cur.val >= biggest.val) {
                biggest = cur;
            } else {
                // 寻找插入位置
                pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                biggest.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = biggest.next;
        }

        return dummy.next;
    }
}
