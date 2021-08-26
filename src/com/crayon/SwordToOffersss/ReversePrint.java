package com.crayon.SwordToOffersss;

import com.crayon.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class ReversePrint {
    /*
     * 看到这个问题我们第一时间想到的就是反转链表后，从头到尾遍历输出
     * 但是这种方法修改了链表原本的结构，《剑指 Offer》 一书中提到了
     * 应该和面试官沟通是否可以修改链表原本的结构，如果不可以，想到可以借助栈来辅助。
     *
     * update: 既然反转链表的方式一定需要遍历两次，那为什么还要反转链表....
     * 知道长度后，继续按顺序遍历即可，数组反向放数据就行....
     * 因为《剑指 Offer》里的描述是反向输出链表的值，而不是像这一题返回一个数组，所以有了反转链表的思路。
     * 感觉这题更像是考递归的写法，栈本身和递归的思路很类似。
     *
     */
    // todo 递归写法。既然借助栈，本身和递归的函数压栈出栈很类似。
    int[] result;
    int i = 0;
    int j = 0;
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};




        return result;
    }

    void resucr(ListNode node) {
        if (node == null) {
            result = new int[i];
            j = result.length - 1;
            return;
        }
        i++;
        resucr(node.next);
        result[j--] = node.val;
    }



    // 不修改链表原本的结构,借助栈
    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[]{};

        Deque<Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (i < result.length) {
            result[i] = stack.pop();
            i++;
        }

        return result;
    }

    // 反转链表
    public int[] reversePrint3(ListNode head) {
        if (head == null) return new int[]{};

        ListNode dummy = new ListNode(-1), cur = head, pre = dummy, newHead = null;
        dummy.next = head;
        int count = 1;
        while (cur.next != null) {
            newHead = cur.next;
            cur.next = newHead.next;

            newHead.next = pre.next;
            pre.next = newHead;
            count++;
        }

        int[] result = new int[count];
        int i = 0;
        cur = pre.next;
        while (cur != null) {
            result[i] = cur.val;
            cur = cur.next;
            i++;
//            System.out.println("val"); break;
        }

        return result;
    }
}
