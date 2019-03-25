package com.darkness463.leetcode.tree;

import com.darkness463.leetcode.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        travel(root, root.val);
        return max;
    }

    private int travel(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int left = travel(root.left, root.val);
        int right = travel(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

}
