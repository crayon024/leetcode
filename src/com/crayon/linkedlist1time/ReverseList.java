package com.crayon.linkedlist1time;

import com.crayon.ListNode;

/**
 * 反转链表 题号 206 <br/>
 * 题目链接 https://leetcode-cn.com/problems/reverse-linked-list/ <br/>
 *
 * @author Crayon
 *
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
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

    /**
     * 双指针, 头插法（这个说法更好理解写）
     */
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

    public static void main(String[] args) {
        ListNode listNodeTrain = ListNodeUtil.createListNodeTrain();
        ListNode listNode = reverseList(listNodeTrain);
        System.out.println("// reverse ");
        System.out.println(listNode.toString());
    }
}
