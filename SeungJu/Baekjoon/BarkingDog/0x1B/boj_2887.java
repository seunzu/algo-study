package MST;

import java.io.*;
import java.util.*;

// 행성 터널
public class boj_2887 {
    static class Planet {
        int idx, x, y, z;

        Planet(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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

    static int N;
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

        N = Integer.parseInt(br.readLine());

        Planet[] arr = new Planet[N];
        unf = new int[N];
        for (int i = 0; i < N; i++) unf[i] = i;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arr[i] = new Planet(i, x, y, z);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.x));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(arr[i].idx, arr[i + 1].idx, Math.abs(arr[i].x - arr[i + 1].x)));
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.y));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(arr[i].idx, arr[i + 1].idx, Math.abs(arr[i].y - arr[i + 1].y)));
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.z));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(arr[i].idx, arr[i + 1].idx, Math.abs(arr[i].z - arr[i + 1].z)));
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
