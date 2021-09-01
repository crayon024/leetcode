package com.crayon.SwordToOffersss;

import com.crayon.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 */
public class IsSymmetric {
    /**
     * [1,2,2,3,4,4,3]
     *
     *      1
     *    /  \
     *   2    2
     *    \   /
     *    4  4
     *     \/
     *     55
     *
     *            1
     *      *    / \
     *      *   2   2
     *      *  / \ / \
     *      * 3  4 4  3
     *      [9,-42,-42,null,76,76,null,null,13,null,13]
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> vals = new LinkedList<>();
        vals.add(root.left);
        vals.add(root.right);
        while (!vals.isEmpty()) {
            TreeNode t = vals.poll();
            TreeNode t2 = vals.poll();

            if (t == null && t2 == null) continue;

            if (t == null || t2 == null || t.val != t2.val) {return false;}

            vals.add(t.left);
            vals.add(t2.right);
            vals.add(t.right);
            vals.add(t2.left);
        }
        return true;
    }
    /**
     * [1,2,2,3,4,4,3]
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 递归：
     * 1. 确定递归函数参数和返回值
     * 2. 确定终止条件
     * 3. 确定单层递归的逻辑
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;

        boolean leftr = recur(left.left, right.right);
        boolean rightr = recur(left.right, right.left);
        return leftr && rightr;
    }









    /**[1,2,2,3,4,4,3]
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 中序遍历 [3,2,4,1,4,2,3]
     *
     */

    /**
     * [1,2,2,2,null,2]
     *       1
     *      / \
     *    2   2
     *   /   /
     *  2   2
     *  should false but true
     */
    List<Integer> arrayList = new ArrayList<Integer>();
    public boolean isSymmetric2(TreeNode root) {
        mid(root);
        int size = arrayList.size();
        if (size == 0 || size == 1) return true;
        if (size % 2 == 0 ) return false;
        for (int i = 0; i < (size + 1) / 2; i++) {
            if (arrayList.get(i) != arrayList.get(size - i - 1)) return false;
        }
        return true;
    }

    void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left);
        arrayList.add(root.val);
        mid(root.right);
    }

}
