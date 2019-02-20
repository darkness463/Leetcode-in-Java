package com.darkness463.leetcode.tree;

import com.darkness463.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverse(root, "", result);
        return result;
    }

    private void traverse(TreeNode node, String pre, List<String> result) {
        if (node == null) {
            return;
        }

        String path;
        if (pre.length() > 0) {
            path = pre + "->" + node.val;
        } else {
            path = "" + node.val;
        }
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        traverse(node.left, path, result);
        traverse(node.right, path, result);
    }

}
