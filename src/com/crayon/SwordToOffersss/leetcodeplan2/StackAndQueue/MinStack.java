package com.crayon.SwordToOffersss.leetcodeplan2.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * 思路：
 * 1. O(1) 的时间复杂度，min() 函数的设计。其他常规函数使用栈结构即可。
 * 2. 整个栈的最小元素，保持一个相同的栈 b，b 的栈顶元素就是当前栈的最小元素
 * 3. 常规的栈 a 需要和 b 联动。b 的栈顶元素根据情况，如果新元素相对更大，栈最小元素还是之前。
 *    这时 b 重复一个元素即可。
 *
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (min.isEmpty()) {
            min.offerLast(x);
        } else {
            // 核心思路
            if (x < min.peekLast()) {
                min.offerLast(x);
            } else {
                min.offerLast(min.peekLast());
            }
        }
    }

    public void pop() {
        stack.pollLast();
        min.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return min.getLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}
