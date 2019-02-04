package com.darkness463.leetcode.tree;

import com.darkness463.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SymmetricTree {

    /**
     * Solution1: 检查各自子树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null)
                || (left != null && right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * Solution2: 获取优先左子树和优先右子树的路径，如果对称，2个路径应该一致。
     */
    public boolean isSymmetric2(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        travelLeft(root, left);
        travelRight(root, right);
        return left.equals(right);
    }

    private void travelLeft(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }
        travelLeft(root.left, result);
        travelLeft(root.right, result);
        result.add(root.val);
    }

    private void travelRight(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }
        travelRight(root.right, result);
        travelRight(root.left, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        {
            TreeNode t1 = new TreeNode(1);
            TreeNode t21 = new TreeNode(2);
            TreeNode t22 = new TreeNode(2);
            TreeNode t31 = null;
            TreeNode t32 = new TreeNode(3);
            TreeNode t33 = null;
            TreeNode t34 = new TreeNode(3);

            t1.left = t21;
            t1.right = t22;
            t21.left = t31;
            t21.right = t32;
            t22.left = t33;
            t22.right = t34;

            System.out.println(new SymmetricTree().isSymmetric(t1));
        }
        {
            TreeNode t1 = new TreeNode(1);
            TreeNode t21 = new TreeNode(2);
            TreeNode t22 = new TreeNode(3);
            TreeNode t31 = new TreeNode(3);
            TreeNode t32 = null;
            TreeNode t33 = new TreeNode(2);
            TreeNode t34 = null;

            t1.left = t21;
            t1.right = t22;
            t21.left = t31;
            t21.right = t32;
            t22.left = t33;
            t22.right = t34;

            System.out.println(new SymmetricTree().isSymmetric(t1));
        }
    }

}
