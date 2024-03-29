package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer II 049: Sum of path numbers from root node to leaf node.
 *      This question is the same as leetcode's 129 questions.
 */
public class OfferII49SumOfPathNumbersFromRootNodeToLeafNode {

    private int result;

    public int sumNumbers(final TreeNode root) {
        dp(root, new StringBuilder());
        return result;
    }

    private void dp(final TreeNode root, final StringBuilder path) {
        if (root == null) {
            return;
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(path.toString());
        }
        dp(root.left, path);
        dp(root.right, path);
        path.deleteCharAt(path.length() - 1);
    }
}
