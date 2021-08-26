package com.crayon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 *
 */
public class CQueue {

    Deque<Integer> one;
    Deque<Integer> two;

    public CQueue() {
        one = new ArrayDeque<>();
        two = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        one.push(value);
    }

    public int deleteHead() {
        if (two.isEmpty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }

        if (!two.isEmpty()) {
            return two.pop();
        } else {
            return -1;
        }
    }

    // more elegant
    public int deleteHeadMoreElegant() {
        if (!two.isEmpty()) { return two.pop(); }
        if (one.isEmpty()) { return -1; }
        while (!one.isEmpty()) { two.push(one.pop()); }
        return two.pop();
    }
}
