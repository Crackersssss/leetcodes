package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 971: Flip Binary Tree To Match Preorder Traversal.
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

    private final List<Integer> result = new ArrayList<>();

    private boolean isFlip;

    private int index;

    public List<Integer> flipMatchVoyage(final TreeNode root, final int[] voyage) {
        isFlip = true;
        index = 0;
        dp(root, voyage);
        return isFlip ? result : Collections.singletonList(-1);
    }

    public void dp(final TreeNode root, final int[] voyage) {
        if (root == null || !isFlip) {
            return;
        }
        if (root.val != voyage[index++]) {
            isFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[index]) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            result.add(root.val);
        }
        dp(root.left, voyage);
        dp(root.right, voyage);
    }
}
