package LeetCode75.BinaryTree.DFS;

// Longest ZigZag Path in a Binary Tree
public class leetcode_1372 {
    class Solution {
        int max = 0;

        void dfs(TreeNode node, boolean goLeft, int len) {
            if (node == null) return;

            max = Math.max(max, len);

            if (goLeft) {
                dfs(node.left, false, len + 1);
                dfs(node.right, true, 1);
            } else {
                dfs(node.right, true, len + 1);
                dfs(node.left, false, 1);
            }
        }

        public int longestZigZag(TreeNode root) {
            dfs(root, true, 0);
            dfs(root, false, 0);

            return max;
        }
    }
}
