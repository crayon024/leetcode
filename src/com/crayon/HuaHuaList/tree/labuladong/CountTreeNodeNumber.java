package com.crayon.HuaHuaList.tree.labuladong;

import com.crayon.TreeNode;

/**
 * 计算一棵树有多少个节点
 */
public class CountTreeNodeNumber {

    public int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
