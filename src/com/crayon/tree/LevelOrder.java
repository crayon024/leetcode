package com.crayon.tree;

import com.crayon.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历 <br/>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china<br/>
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> everyLevelsNodes = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelCount = queue.size();

            while (levelCount > 0) {
                TreeNode poll = queue.poll();
                everyLevelsNodes.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                levelCount--;
            }

            result.add(everyLevelsNodes);
            everyLevelsNodes = new LinkedList<>();
        }
        return result;
    }

}
