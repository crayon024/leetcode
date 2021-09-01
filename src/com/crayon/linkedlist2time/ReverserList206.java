package com.crayon.linkedlist2time;

import com.crayon.ListNode;

public class ReverserList206 {
    /**
     *    -1(pre) -> 1(cur) -> 2(remove) -> 3 -> 4 -> 5 -> null
     *    -1(pre) -> 2 -> 1(cur) -> 3 -> 4 -> 5 -> null
     *
     *   头插法总结， pre 不能动，需要保证后续的节点插到头部， cur 其实也没有动
     *   */
    public static ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, cur = head, remove = null;
        while (cur.next != null) {
            remove = cur.next;
            cur.next = remove.next;

            remove.next = pre.next;
            pre.next = remove;
        }
        return dummy.next;
    }
}
