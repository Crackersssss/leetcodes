package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer II 55: Balanced Binary Tree.
 *      This question is the same as leetcode's 110 questions.
 */
public class Offer55IIBalancedBinaryTree {

    private boolean result = true;

    public boolean isBalanced(final TreeNode root) {
        dp(root);
        return result;
    }

    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}
