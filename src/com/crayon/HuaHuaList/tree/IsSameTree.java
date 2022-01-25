package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 总结：
 * 1. 38 - 42 行的节点为空判断
 */
public class IsSameTree {

    /*
     * 广度优先遍历
     * 两个元素两个元素进行比较
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 迭代法 借助队列
        if (p == null && q == null)
            return true;
        Queue<TreeNode> que = new LinkedList<>();
        // 存入p q 根节点
        que.offer(p);
        que.offer(q);
        while (!que.isEmpty()) {
            // 一次弹出两个结点比较
            TreeNode nodep = que.poll();
            TreeNode nodeq = que.poll();

            // 两者都为空 继续比较下一组
            if (nodep == null && nodeq == null)
                continue;

            // 判断是否相同。结构相同 值相同
            if (nodep == null || nodeq == null || nodep.val != nodeq.val)
                return false;

            // 每次两边孩子结点都入队
            // p 左 q左
            que.offer(nodep.left);
            que.offer(nodeq.left);

            // p 右 q右
            que.offer(nodep.right);
            que.offer(nodeq.right);
        }
        return true;
    }

    /*
     * 递归
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}
