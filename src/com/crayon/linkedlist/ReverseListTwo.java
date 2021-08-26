package com.crayon.linkedlist;

import com.crayon.ListNode;

/**
 * 反转给定起始点位置中间部分的链表 题号 92 <br/>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/ <br/>

 * 链表中节点数目为 n
 *      1 <= n <= 500
 *      -500 <= Node.val <= 500
 *      1 <= left <= right <= n
 */
public class ReverseListTwo {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left < 0 || right < 0 || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }


        ListNode cur = pre.next;
        ListNode next= null;

        ListNode pre_start = pre;
        ListNode middle_tail = cur;
        int i = left;
        while (i < right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

            i++;
        }

        middle_tail.next = cur;
        pre_start.next = pre;

        return dummy.next;
    }

    /*
    * 头插法
    * */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || left > right) {return null;}

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, remove = null, cur = null;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        cur = pre.next;

        for (int j = left; j < right; j++) {
            remove = cur.next;
            cur.next = remove.next;

            /*
            头插法需要一直保存 头 的位置(pre.next)

            且不能改变引用 cur，cur 应该一直指向待反转链表的头部节点
            pre 作为待反转链表的前一个节点，需要 dummy 节点配合。
            即不能将下面的语句替换为 remove.next = cur;
            * */
            remove.next = pre.next;
            pre.next = remove;

        }
        return dummy.next;
    }
}
