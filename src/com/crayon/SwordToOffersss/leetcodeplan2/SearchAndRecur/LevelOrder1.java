package com.crayon.SwordToOffersss.leetcodeplan2.SearchAndRecur;

import com.crayon.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 思路 1：
 * 1. 题目要求返回一个数组。在不知道二叉树的大小前提下，在遍历过程中无法使用定义好的原始数组。
 * 2. 利用队列，从头节点开始，每个节点的左右节点往队列后存放。依次拿出来存储
 * 3. 空间复杂度：O(\n) ，利用到两个辅助空间。时间复杂度 O(n), 两次独立的遍历。
 * 4. 看了题解，原来这是 BFS 广度优先搜索的实现思路，利用队列
 */
public class LevelOrder1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        Deque<TreeNode> list = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        list.offerLast(root);
        while (!list.isEmpty()) {
            TreeNode treeNode = list.pollFirst();
            result.offerLast(treeNode.val);
            if (treeNode.left != null) list.offerLast(treeNode.left);
            if (treeNode.right != null) list.offerLast(treeNode.right);
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.pollFirst();
        }
        return r;
    }
}
