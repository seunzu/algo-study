package LeetCode75.BinaryTree.DFS;

// Count Good Nodes in Binary Tree
public class leetcode_1448 {
    class Solution {
        int dfs(TreeNode node, int max) {
            if (node == null) return 0;

            int cnt = 0;
            if (node.val >= max) cnt = 1;

            max = Math.max(max, node.val);

            cnt += dfs(node.left, max);
            cnt += dfs(node.right, max);

            return cnt;
        }

        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }
    }
}
