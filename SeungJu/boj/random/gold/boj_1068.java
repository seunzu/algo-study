package gold;

import java.io.*;
import java.util.*;

// 트리
public class boj_1068 {
    static int N, removeNode, root;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt = 0;

    static void dfs(int v) {
        visited[v] = true;

        if (v == removeNode) return;

        boolean flag = true;
        for (int next : graph.get(v)) {
            if (next == removeNode) continue;
            if (!visited[next]) {
                flag = false;
                dfs(next);
            }
        }

        if (flag) cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] parent = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) root = i;
            else graph.get(parent[i]).add(i);
        }

        removeNode = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        if (removeNode == root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(cnt);
        }
    }
}
