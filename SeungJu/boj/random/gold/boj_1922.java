package gold;

import java.io.*;
import java.util.*;

// 네트워크 연결
public class boj_1922 {
    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static List<Edge> edges;
    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fb] = fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int total = 0;
        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                total += e.cost;
            }
        }

        System.out.println(total);
    }
}
