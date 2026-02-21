package graph;

import java.io.*;
import java.util.*;

// DFS와 BFS
public class boj_1260 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int nv : graph.get(v)) {
            if (!visited[nv]) DFS(nv);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int nv : graph.get(cur)) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    queue.offer(nv);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }
}
