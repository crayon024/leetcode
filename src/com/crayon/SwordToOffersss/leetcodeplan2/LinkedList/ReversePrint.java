package com.crayon.SwordToOffersss.leetcodeplan2.LinkedList;

import com.crayon.ListNode;

/**
 *  剑指 Offer 06. 从尾到头打印链表
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  思路：
 *  1. 数组返回，只要知道数组的长度就行。
 *  2. 遍历链表获得长度
 *  3. 数组下标反着放就行
 *
 *  b. 用栈，栈顶元素就是链表的尾巴元素
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        int i = 0;
        ListNode l = head;
        while (l != null) {
            i++;
            l = l.next;
        }
        int[] result = new int[i];
        while (head != null) {
            result[--i] = head.val;
            head = head.next;
        }
        return result;
    }
}
