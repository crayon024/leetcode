package com.crayon.linkedlist;

import com.crayon.ListNode;

/**
 * @author Crayon
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode pre = null;
        ListNode temp = null;
        while (p != null) {
            temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
