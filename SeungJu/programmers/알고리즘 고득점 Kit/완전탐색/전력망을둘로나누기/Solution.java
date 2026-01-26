package 완전탐색.전력망을둘로나누기;

import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt;

    static void dfs(int node, int cutA, int cutB) {
        visited[node] = true;
        cnt++;

        for (int next : graph.get(node)) {
            if ((node == cutA && next == cutB) || (node == cutB && next == cutA)) continue;

            if (!visited[next]) dfs(next, cutA, cutB);
        }
    }

    public int solution(int n, int[][] wires) {

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];

            visited = new boolean[n + 1];
            cnt = 0;

            dfs(a, a, b);

            ans = Math.min(ans, Math.abs(cnt - (n - cnt)));
        }

        return ans;
    }
}