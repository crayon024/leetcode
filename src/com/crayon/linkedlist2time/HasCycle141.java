package com.crayon.linkedlist2time;

import com.crayon.ListNode;

public class HasCycle141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, quick = head;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) return true;
        }
        return false;
    }
}
