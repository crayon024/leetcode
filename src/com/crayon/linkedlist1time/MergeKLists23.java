package com.crayon.linkedlist1time;

import com.crayon.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists23 {


    /**
     * 优先队列思路 2
     *
     * 看到优先队列的思路后，想法就是挨个全放进队列里
     *
     * 看到一个更好的思路，因为 lists 里面的node都是有序的
     * 可以先入队每个链表的头节点，然后出队一个，说明他是最小的，然后把这个 node.next 往优先队列里放
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        PriorityQueue<ListNode> min_heap = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));

        for (ListNode l : lists) {
            if (l == null) continue;
            min_heap.add(l);
        }

        ListNode head = new ListNode(-1), result = head;
        while (!min_heap.isEmpty()) {
            ListNode curMin = min_heap.poll();
            head.next = curMin;
            head = head.next;
            if (curMin.next != null)
            min_heap.add(curMin.next);
        }

        return result.next;
    }

    /**
     * 看到优先队列的思路后，想法就是挨个全放进队列里
     *
     * 看到一个更好的思路，因为 lists 里面的node都是有序的
     * 可以先入队每个链表的头节点，然后出队一个，说明他是最小的，然后把这个 node.next 往优先队列里放
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> listNodes = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.val, l1.val));

        for (ListNode l : lists) {
            while (l != null) {
                listNodes.add(l);
                l = l.next;
            }
        }

        ListNode dummy = new ListNode(-1), result = dummy;
        while (!listNodes.isEmpty()) {
            dummy.next = listNodes.poll();
            dummy = dummy.next;
        }
        // [[-2,-1,-1,-1],[]], 倒二个 node 最后出队，那个 node.next 指向了倒一个 node
        dummy.next = null;

        return result.next;
    }
}
