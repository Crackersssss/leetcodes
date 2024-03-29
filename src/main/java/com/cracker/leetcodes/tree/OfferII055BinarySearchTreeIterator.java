package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is Leetcode Offer II 055. Binary search tree iterator.
 *      This question is the same as leetcode's 173 questions.
 */
public class OfferII055BinarySearchTreeIterator {

    static class BSTIterator {

        private final Deque<TreeNode> stack = new ArrayDeque<>();

        BSTIterator(final TreeNode root) {
            build(root);
        }

        private void build(final TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            build(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
