package LeetCode75.BinaryTree.BFS;

// Binary Tree Right Side View
public class leetcode_199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            if (root == null) return arr;

            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();

                    if (i == size - 1) {
                        arr.add(node.val);
                    }

                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }

            return arr;
        }
    }
}
