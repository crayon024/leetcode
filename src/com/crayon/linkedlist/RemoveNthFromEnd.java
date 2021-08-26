package com.crayon.linkedlist;


import com.crayon.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点 <br/>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/ <br/>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arrayList = new ArrayList<ListNode>();


        ListNode p = head;
        while (p != null) {
            arrayList.add(p);
            p = p.next;
        }

        int length = arrayList.size();

        int i = length - n - 1;

        if (n == length) {
            return head.next;
        }

        ListNode listNode = arrayList.get(i);
        listNode.next = listNode.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy, quick = dummy;

        int i = 0;
        while (quick != null) {
            quick = quick.next;
            if (i > n) { slow = slow.next; }
            i++;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
