package com.crayon.SwordToOffersss.leetcodeplan2.StackAndQueue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 思路：优先出队的元素交给 stack2
 * 队列先进先出，stack2 的栈顶元素始终是 stack1 倒出来。只有 stack2 空后，<b>才从 stack1 一次性放进来</b>
 * 1. 入队操作：stack1 放到栈顶
 * 2. 出队操作：总是从 stack2 出队，stack2 没有元素的时候需要判断 stack1 的情况。
 * 3. stack1 和 2 都没有元素才表示队列为空。
 */
public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
