package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 <b>根节点到叶子节点</b> 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/problems/path-sum
 */
public class HasPathSum {
    /*
     * 递归：
     * 如何分解成子问题？ -> (targetSum - last.node.val) == node.val
     * 对每个节点来说，遍历过程中减去 node.val，当到达叶子节点的时候，剩余的值能否刚好变成 1
     *
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //1. 递归终止条件 - 空树
        if (root == null) return false;
        //1. 叶子节点 -> 判断剩下的值是不是一样，一样说明有对应的 路径和
        if (root.left == null && root.right == null) return root.val == targetSum;
        int sum = targetSum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
