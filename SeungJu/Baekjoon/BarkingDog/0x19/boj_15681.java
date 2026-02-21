package tree;

import java.io.*;
import java.util.*;

// 트리와 쿼리
public class boj_15681 {
    static List<List<Integer>> tree;
    static int[] subTreeSize;
    static boolean[] visited;

    static int dfs(int node) {
        visited[node] = true;
        int size = 1;

        for (int nex : tree.get(node)) {
            if (!visited[nex]) size += dfs(nex);
        }

        subTreeSize[node] = size;
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        subTreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(R);

        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subTreeSize[u]).append("\n");
        }

        System.out.println(sb);
    }
}
