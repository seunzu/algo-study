package 그래프.가장먼노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        int max = 0;
        for (int d : distance) max = Math.max(max, d);

        int cnt = 0;
        for (int d : distance) {
            if (d == max) cnt++;
        }

        return cnt;
    }
}