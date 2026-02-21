package graph;

import java.io.*;
import java.util.*;

// 효율적인 해킹
public class boj_1325 {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }

        int[] arr = new int[N + 1];
        int maxHack = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            arr[i] = bfs(i);
            maxHack = Math.max(maxHack, arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == maxHack) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
