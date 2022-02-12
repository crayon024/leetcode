package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * 总结：
 * 1. 刷过很多次
 * 2. 广度优先搜索思路可以很顺地写下来,细节上仍有问题
 *  1. i-- 写成 i++
 *  2. 使用到容器的 size() 注意 null 元素也可能占一格
 *  3. put null element 影响 isEmpty() 的判断
 *
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> list = new LinkedList<>();

        list.offer(root);
        while (!list.isEmpty()) {
            List<Integer> num = new LinkedList<>();
            for (int i = list.size(); i > 0; i--) {
                TreeNode poll = list.poll();
                num.add(poll.val);
                if (poll.left != null)
                list.offer(poll.left);
                if (poll.right != null)
                list.offer(poll.right);
            }
            result.add(num);
        }
        return result;
    }
    public static void main(String[] args) {
        Queue<Integer> x = new LinkedList<>();
        x.offer(null);
        x.add(null);
        // print 2
        System.out.println(x.size());
        System.out.println(x.isEmpty());
    }
}
