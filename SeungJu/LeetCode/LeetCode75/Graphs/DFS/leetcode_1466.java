package LeetCode75.Graphs.DFS;

// Reorder Routes to Make All Paths Lead to the City Zero
public class leetcode_1466 {
    class Solution {
        List<List<int[]>> graph;
        boolean[] visited;
        int changes = 0;

        void dfs(int city) {
            visited[city] = true;

            for (int[] next : graph.get(city)) {
                int nextCity = next[0];
                int cost = next[1];

                if (!visited[nextCity]) {
                    changes += cost;
                    dfs(nextCity);
                }
            }
        }

        public int minReorder(int n, int[][] connections) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] c : connections) {
                int a = c[0];
                int b = c[1];

                graph.get(a).add(new int[]{b, 1});
                graph.get(b).add(new int[]{a, 0});
            }

            visited = new boolean[n];
            dfs(0);

            return changes;
        }
    }
}
