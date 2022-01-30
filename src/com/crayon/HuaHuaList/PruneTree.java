package com.crayon.HuaHuaList;

import com.crayon.TreeNode;

/**
 * 814. 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning

 */
public class PruneTree {

    /**
     * 后序遍历
     */
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return true;

        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;

        /*
         * 如果该节点为 1 这颗树就不用被剪
         * 如果为 0，则看左右子树，
         */
        return node.val == 1 || left || right;
    }

    /**
     *  将root这棵树剪枝，返回剪枝后的树
     */
    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);   // 左子树剪枝，得到剪枝后左子树
        root.right = pruneTree(root.right); // 右子树剪枝，得到剪枝后右子树
        // 判断决定root结点是否需要剪掉：
        if (root.left == null && root.right == null && root.val == 0) return null;
        // 返回root这棵树剪枝后的结果
        return root;
    }
}
