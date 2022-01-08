package com.crayon.SwordToOffersss.leetcodeplan2.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  剑指 Offer 35. 复杂链表的复制
 *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *  还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  错误思路：
 *  第一遍遍历的同时设置 next 指针。
 *  正确思路 - 1：
 *  1. 先遍历复制一遍 node ，用 map 对应存起来。这一步不用管指针的连接
 *  2. 遍历原链表，设置 next 和 random 指针。在 map 里设置对应的新 node 即可。

    思路 - 2：迭代 + 拆分
    1 -> 1' -> 2 -> 2' -> 3 -> 3' - null

 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head, result = null;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            result = map.get(cur);
            result.next = map.get(cur.next);
            result.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }



    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
