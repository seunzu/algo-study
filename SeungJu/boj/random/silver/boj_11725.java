package silver;

import java.io.*;
import java.util.*;

// 트리의 부모 찾기
public class boj_11725 {
    static List<List<Integer>> tree;
    static int[] arr;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int next : tree.get(node)) {
            if (!visited[next]) {
                arr[next] = node;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
