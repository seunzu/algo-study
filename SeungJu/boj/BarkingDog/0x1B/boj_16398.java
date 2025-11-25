package MST;

import java.io.*;
import java.util.*;

// 행성 연결
public class boj_16398 {
    static class Edge implements Comparable<Edge> {
        int u, v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }
    }

    static int N;
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

        N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long cost = Long.parseLong(st.nextToken());
                if (i < j) edges.add(new Edge(i, j, cost));
            }
        }

        unf = new int[N];
        for (int i = 0; i < N; i++) unf[i] = i;

        Collections.sort(edges);

        long total = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                total += e.w;
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        System.out.println(total);
    }
}
