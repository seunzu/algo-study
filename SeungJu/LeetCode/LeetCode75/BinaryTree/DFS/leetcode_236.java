package LeetCode75.BinaryTree.DFS;

// Lowest Common Ancestor of a Binary Tree
public class leetcode_236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;

            TreeNode lt = lowestCommonAncestor(root.left, p, q);
            TreeNode rt = lowestCommonAncestor(root.right, p, q);

            if (lt != null && rt != null) return root;

            return lt != null ? lt : rt;
        }
    }
}
