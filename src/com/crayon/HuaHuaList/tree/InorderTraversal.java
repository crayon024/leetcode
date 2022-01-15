package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 参照 huahua-problem-list 进行练习
 * https://zxi.mytechroad.com/blog/leetcode-problem-categories/
 *
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {
    /*
     * 迭代法 - 中序遍历
     * 思路：每到一个节点 A，因为根的访问在中间，将 A 入栈。然后遍历左子树，接着访问 A，最后遍历右子树。
            在访问完 A 后，A 就可以出栈了。因为 A 和其左子树都已经访问完成。
     *
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/die-dai-fa-by-jason-2/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    /*
     * 迭代法 - 前序遍历
     * 思路：根节点先访问，然后访问左子树，所以需要把右子树压栈
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur.right);
                result.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
        }
        return result;
    }

    /*
     * 递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recur(root, result);
        return result;
    }

    public void recur(TreeNode node, List<Integer> list) {
        if (node == null) return;
        recur(node.left, list);
        list.add(node.val);
        recur(node.right, list);
    }
}
