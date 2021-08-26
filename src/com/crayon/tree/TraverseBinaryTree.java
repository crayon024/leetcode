package com.crayon.tree;

import com.crayon.TreeNode;

public class TraverseBinaryTree {

    public void preOrderTraverse(TreeNode root) {
        TreeNode p = root;
        if (p == null) return;
        System.out.println("node's val = " + p.val);
        preOrderTraverse(p.left);
        preOrderTraverse(p.right);
    }
}
