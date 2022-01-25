package com.crayon.HuaHuaList.tree.labuladong;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针 
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 *
 * 总结:
 * 1.Queue 接口的实现类 LinkedList#offer() support null element
 */
public class Connect {
    /*
     * 深度
     * TODO
     */
    public Node connect(Node root) {

        return root;
    }

    /*
     * 广度优先遍历
     * O(n) 空间复杂度
     */
    public Node connect1(Node root) {
        if (root == null) return null;
        Queue<Node> list = new ArrayDeque<>();
        list.offer(root);
        while (!list.isEmpty()) {
            for (int i = list.size(); i > 0; i--) {
                Node poll = list.poll();
                // offer api 不支持入队 null 元素
                if (poll.left != null) list.offer(poll.left);
                if (poll.right != null) list.offer(poll.right);
                if (i != 1) poll.next =  list.peek();
                else poll.next = null;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
