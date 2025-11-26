package MST;

import java.io.*;
import java.util.*;

// 우주신과의 교감
public class boj_1774 {
    static class Edge implements Comparable<Edge> {
        int a, b;
        double cost;

        public Edge(int a, int b, double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static int[] unf;
    static int[][] pos;
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

    static double dist(int x, int y) {
        long dx = pos[x][0] - pos[y][0];
        long dy = pos[x][1] - pos[y][1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new int[N + 1][2];
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new Edge(i, j, dist(i, j)));
            }
        }

        Collections.sort(edges);

        double ans = 0.0;
        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                ans += e.cost;
            }
        }

        System.out.printf("%.2f", ans);
    }
}
