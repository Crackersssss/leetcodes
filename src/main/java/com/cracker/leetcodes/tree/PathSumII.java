package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 113: Path Sum II.
 */
public class PathSumII {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(final TreeNode root, final int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        dp(root, new LinkedList<>(), targetSum);
        return result;
    }

    private void dp(final TreeNode root, final LinkedList<Integer> path, final int targetSum) {
        if (root == null) {
            return;
        }
        int sum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                path.addLast(root.val);
                result.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }
        path.addLast(root.val);
        dp(root.left, path, sum);
        path.removeLast();
        path.addLast(root.val);
        dp(root.right, path, sum);
        path.removeLast();
    }
}
