package com.crayon.linkedlist;

import com.crayon.ListNode;

/**
 * 21. 合并两个有序链表 <br/>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/ <br/>
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    // update
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 == null) result.next = l2;
        if (l2 == null) result.next = l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode dummy = new ListNode(-1), p = dummy;
        while (true) {
            if (l1 == null) {
                p.next = l2;
                return dummy.next;
            } else if (l2 == null){
                p.next = l1;
                return dummy.next;
            }
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
    }
}
