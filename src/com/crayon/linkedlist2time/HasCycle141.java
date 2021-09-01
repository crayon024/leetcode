package com.crayon.linkedlist2time;

import com.crayon.ListNode;

public class HasCycle141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, quick = head.next;

        while (slow != null && quick != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) return true;
        }

        return false;
    }
}
