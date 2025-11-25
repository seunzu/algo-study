package MST;

import java.io.*;
import java.util.*;

// 물대기
public class boj_1386 {
    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fb] = fa;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            int w = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, w));
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i < j) edges.add(new Edge(i, j, cost));
            }
        }

        unf = new int[N + 1];
        for (int i = 0; i <= N; i++) unf[i] = i;

        Collections.sort(edges);

        long total = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                total += e.cost;
                cnt++;
                if (cnt == N) break;
            }
        }

        System.out.println(total);
    }
}
