package LeetCode75.Graphs.DFS;

// Number of Provinces
public class leetcode_547 {
    class Solution {
        int n;
        int[][] isConnected;
        boolean[] visited;

        void dfs(int city) {
            visited[city] = true;

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !visited[j]) {
                    dfs(j);
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            n = isConnected.length;
            this.isConnected = isConnected;
            visited = new boolean[n];
            int provinces = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    provinces++;
                }
            }

            return provinces;
        }
    }
}
