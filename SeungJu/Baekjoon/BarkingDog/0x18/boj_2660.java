package graph;

import java.io.*;
import java.util.*;

// 회장뽑기
public class boj_2660 {
    static int N;
    static List<List<Integer>> graph;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int[] dist = new int[N + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int score = 0;
        for (int i = 1; i <= N; i++) {
            score = Math.max(score, dist[i]);
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] score = new int[N + 1];
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            score[i] = bfs(i);
            minScore = Math.min(minScore, score[i]);
        }

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == minScore) arr.add(i);
        }

        sb.append(minScore).append(" ").append(arr.size()).append("\n");
        for (int a : arr) sb.append(a).append(" ");

        System.out.println(sb);
    }
}
