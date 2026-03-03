package LeetCode75.BinaryTree.DFS;

// Path Sum 3
public class leetcode_437 {
    class Solution {
        int dfs(TreeNode node, long target) {
            if (node == null) return 0;

            int cnt = 0;
            if (node.val == target) cnt++;

            cnt += dfs(node.left, target - node.val);
            cnt += dfs(node.right, target - node.val);

            return cnt;
        }

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;

            return dfs(root, targetSum)
                    + pathSum(root.left, targetSum)
                    + pathSum(root.right, targetSum);
        }
    }
}
