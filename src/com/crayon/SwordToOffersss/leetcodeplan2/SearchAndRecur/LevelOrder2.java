package com.crayon.SwordToOffersss.leetcodeplan2.SearchAndRecur;

import com.crayon.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 思路：
 * 和 32-I 从上到下打印二叉树 I 的思路一样。不同的地方在要求返回的函数，需要每一层单独区分保存出来。
 * 1. 问题转换成怎么找到每一层元素的个数区分
 * 2. 巧妙的点在于 for 循环一开始时，此时 list 的大小就是这一层的个数，先定义 i = list.size() 把个数固定下来
 *    避免 list 的大小一直变。
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(2);

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> list = new ArrayDeque<>();
        list.offerLast(root);

        while (!list.isEmpty()) {
            List<Integer> row = new ArrayList<>(list.size());
            for (int i = list.size(); i > 0; i--) { // key point, int i = list.size() first

                TreeNode treeNode = list.pollFirst();
                row.add(treeNode.val);

                if (treeNode.left != null) list.offerLast(treeNode.left);
                if (treeNode.right != null) list.offerLast(treeNode.right);
            }
            result.add(row);
        }
        return result;
    }
}
