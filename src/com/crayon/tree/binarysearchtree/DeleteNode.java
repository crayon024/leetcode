package com.crayon.tree.binarysearchtree;

import com.crayon.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点 <br>
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/ <br>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 *
 */
public class DeleteNode {

    /**
     * 删除节点后为了保证仍满足二叉搜索树的特点（左子树都小，右子树都大）
     * 需要分成几种情况
     * 1. 待删除节点没有左右子树，直接将其父节点指向它的指针赋为 null
     * 2. 待删除节点有一个子树
     *  1）左子树中的最大节点替换到待删除节点的位置
     *  2）右子树中的最小节点提供到待删除节点的位置
     * 3. 有左右子树。右子树中的最小节点，先将该节点替换到待删除节点的位置上，
     *    再删除这个最小节点（这个最小节点的子树情况只会符合 1或者2的情况）
     *    也就是说第三步的操作其实是步骤 1 和 2 的规则组合。
     */
    public static TreeNode deleteNode(TreeNode root, int key) {

        return root;
    }
}
