package MST;

import java.io.*;
import java.util.*;

// 전기가 부족해
public class boj_10423 {
    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, K;
    static int[] unf;
    static List<Edge> edges = new ArrayList<>();

    static int find(int x) {
        if (x == unf[x]) return x;
        return unf[x] = find(unf[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) unf[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        for (int i = 1; i < K; i++) {
            int next = Integer.parseInt(st.nextToken());
            union(first, next);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        int minCost = 0;
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                minCost += e.cost;
            }
        }

        System.out.println(minCost);
    }
}
