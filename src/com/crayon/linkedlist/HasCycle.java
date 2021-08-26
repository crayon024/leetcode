package com.crayon.linkedlist;

import com.crayon.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断环形链表 题号 141 <br/>
 * https://leetcode-cn.com/problems/linked-list-cycle/ <br/>
 *
 * 链表尾部拉环出来
 **/

public class HasCycle {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, quick = head.next;

        while (quick != null && quick.next != null && slow.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    // HashMap
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;

        Map<ListNode, ListNode> hashmap = new HashMap<>(2^9);
        while (head != null) {
            if (hashmap.containsKey(head)) {
                return true;
            }
            hashmap.put(head, null);

            head = head.next;
        }
        return false;
    }
}
