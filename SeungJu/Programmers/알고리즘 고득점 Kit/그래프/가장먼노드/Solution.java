package 그래프.가장먼노드;

import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static int[] dist;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        bfs(1);

        int max = 0;
        for (int d : dist) {
            max = Math.max(max, d);
        }

        int cnt = 0;
        for (int d : dist) {
            if (d == max) cnt++;
        }

        return cnt;
    }
}