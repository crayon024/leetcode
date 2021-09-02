package com.crayon.linkedlist2time;

import com.crayon.ListNode;

import java.util.HashSet;

public class DetectCycle142 {

    /**
     *  s == f 的情况，f 肯定比 s 多走了 n 个 b 圈
     *
     *  f = s + nb , f = 2s
     *  s = nb
     *
     *  入环点 a + nb（疯狂整数绕圈）
     *  此时 slow 走了 nb 步，再走 a 步就是入环点，a 表示 head 到 入环点的距离
     *
     */

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;

        while (head != slow) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
