package com.crayon.tree;


import com.crayon.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 */
public class RebuildBinaryTree {

    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历，方便递归时依据索引查看先序遍历的值

    /*
     * 先序遍历的第一个节点是根节点，拿着这个根节点到中序遍历里找
     * 找到后，这个根节点的左侧个数就左子树的节点，并可以知道有多少个，假设 n 个
     * 知道有多少个后，前序遍历中第一个节点后的 n 个就都是左子树节点。剩下的就是右子树。
     * 然后，知道访问后，就继续递归，
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;// 相等的话就是自己

        int root = preorder[pre_root]; // 从先序里拿到根节点
        int root_index = map.get(root); // 在中序中的位置 可以知道两个子树的数量

        TreeNode treeNode = new TreeNode(root);

        treeNode.left = recur(pre_root + 1, in_left, root_index - 1);

        treeNode.right= recur(pre_root + root_index + 1, root_index + 1, in_right);

        return treeNode;
    }
}
