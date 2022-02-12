package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class SumNumbers {
    /*
     * 深度优先遍历 递归
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,  0);
    }

    public int dfs(TreeNode node, int num) {
        /*
         * 错误：
         * if (node == null) return num;
         */
        if (node == null) return 0;
        // 到叶子节点需要返回，把一路上加的的值返回出来
        if (node.left == null && node.right == null) {
            return node.val + num * 10;
        }

        /*
         * 错误：
         * int leftDfs = dfs(node.left, node.val);
         * int rightDfs = dfs(node.right, node.val);
         */
        int leftDfs = dfs(node.left, node.val + num * 10);
        int rightDfs = dfs(node.right, node.val + num * 10);
        return leftDfs + rightDfs;
    }

    // 广度优先遍历
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        nodes.offer(root);
        nums.offer(root.val);
        while (!nodes.isEmpty()) {
            TreeNode poll = nodes.poll();
            Integer num = nums.poll();
            // 叶子节点
            if (poll.left == null && poll.right == null) {
                sum += num;
            }
            if (poll.left != null) {
                nodes.offer(poll.left);
                nums.offer(num * 10 + poll.left.val);
            }
            if (poll.right != null) {
                nodes.offer(poll.right);
                nums.offer(num * 10 + poll.right.val);
            }
        }
        return sum;
    }
}
