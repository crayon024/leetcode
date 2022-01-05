package com.crayon.SwordToOffersss.leetcodeplan2.LinkedList;

import com.crayon.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 思路：
 *  1. 正常翻转。注意最后返回的头指针
 *  2. 头插法反转。注意 temp.next = pre.next;
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, temp = null;
        // 1 -> 2 -> null
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 头插法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = dummy, temp = null;

        /**
         *  / dummy -> 1 -> 2 -> 3 -> null
         *  dummy -> 2 -> 1 (cur) -> 3 -> null
         *  dummy -> 3 -> 2 -> 1 (cur) -> null
         */
        if (cur == null) return null;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;

            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
