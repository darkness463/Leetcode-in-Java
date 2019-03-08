package com.darkness463.leetcode.tree;

import com.darkness463.leetcode.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class CovertBstToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        getValue(root, 0);
        return root;
    }

    private int getValue(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }

        sum = getValue(node.right, sum);
        node.val = sum + node.val;
        sum = getValue(node.left, node.val);
        return sum;
    }

}
