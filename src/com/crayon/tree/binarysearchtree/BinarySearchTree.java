package com.crayon.tree.binarysearchtree;

import com.crayon.TreeNode;

/**
 * 二叉查找数, 也称二叉搜索树。
 * 特定是对于每个节点，其左子树的<b>所有节点值都</b>小于该节点，其右子树的所有节点值<b>都</b>大于该节点。
 */
public class BinarySearchTree {
    private TreeNode tree;

    /**
     * 查找操作 
     */
    public TreeNode find(int val) {
        TreeNode p = tree;
        while (p != null) {
            if (val < p.val) {
                p = p.left;
            } else if (val > p.val) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入操作（不支持重复元素版本）<br>
     * 1. 小于当前节点，在左子树中继续查找，直到某个节点的左子树为空，插入 Node <br>
     * 2. 大于当前节点，往右子树中查找，直到某个节点的右子树为空，插入 Node
     */
    public void insert(int val) {
        if (tree == null) {
            tree = new TreeNode(val);
            return;
        }

        TreeNode p = tree, treeNode = new TreeNode(val);
        while (p != null) {
            if (val > p.val) {
                if (p.right == null) {
                    p.right = treeNode;
                    break;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = treeNode;
                    break;
                }
                p = p.left;
            }
        }
        return;
    }
}
