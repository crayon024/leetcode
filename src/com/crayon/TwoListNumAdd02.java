package com.crayon;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class TwoListNumAdd02 {
    /*
     * 计算链表
     * 转化成数字进行计算，溢出问题
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode dummy = l3;
        int a = 0, b = 0;
        while (l1 != null && l2 != null) {
            a = l1.val;
            b = l2.val;

            l3.next = new ListNode(a + b);
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l3.next = l1 != null ? l1 : l2;
//        ListNode cur = reverseList(dummy), result = cur, pre = null;
        ListNode cur = dummy.next, result = cur, pre = null;

        int num = 0;
        while (cur != null) {
            cur.val += num / 10; // 高位 进 1 -> /10
            num = 0;
            while (cur.val >= 10) {
                cur.val = cur.val - 10;
                num += 10;
            }
            pre = cur;
            cur = cur.next;
        }
        if (num != 0) {
            pre.next = new ListNode(num / 10);
        }

        return result;
    }

    // 倒序直接拼接就是结果，不用反转链表
    ListNode reverseList(ListNode l) {
        ListNode pre = null, cur = l.next, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
