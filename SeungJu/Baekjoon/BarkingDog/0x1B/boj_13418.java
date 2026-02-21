package MST;

import java.io.*;
import java.util.*;

// 학교 탐방하기
public class boj_13418 {
    static class Edge implements Comparable<Edge> {
        int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int[] unf;
    static List<Edge> edges;

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

    static int mst() {
        unf = new int[N + 1];
        for (int i = 0; i <= N; i++) unf[i] = i;

        int cnt = 0;
        int uphill = 0;

        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                if (e.cost == 0) uphill++;
                cnt++;
                if (cnt == N) break;
            }
        }

        return uphill;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        edges.sort((o1, o2) -> o2.cost - o1.cost);
        int best = mst();

        Collections.sort(edges);
        int worst = mst();

        System.out.println(worst * worst - best * best);
    }
}
