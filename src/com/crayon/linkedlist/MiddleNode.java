package com.crayon.linkedlist;

import com.crayon.ListNode;

/**
 * 876. 链表的中间结点 <br/>
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/ <br/>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        // 可以不必利用 dummy 节点
        ListNode dummy = new ListNode(-1), slow = dummy, quick = dummy;
        dummy.next = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return quick == null ? slow : slow.next;
    }
}
