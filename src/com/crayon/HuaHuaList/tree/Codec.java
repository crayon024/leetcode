package com.crayon.HuaHuaList.tree;

import com.crayon.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 *
 * 1. dfs 解法
 * 2. bfs 解法也可以
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        // 添加分隔符，便于反序列化时的分割
        if (node == null) {
            sb.append("x").append(" ");
            return;
        } else {
            sb.append(node.val).append(" ");
        }
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        /*
         * 1. 使用集合类辅助
         * 2. 可以考虑直接用队列, 这样辅助函数出队操作可以去除代码行 (2)
         */
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(s));
        return rebuild(strings);
    }
    public TreeNode rebuild(ArrayList<String> strings) {
        String s = strings.get(0);
        // (2)
        strings.remove(0);
        if (s.equals("x")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = rebuild(strings);
        treeNode.right = rebuild(strings);
        return treeNode;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
