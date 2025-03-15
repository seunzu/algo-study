package tree;

import java.io.*;
import java.util.*;

// 트리의 부모 찾기
public class boj_11725 {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    static void findParents(int root) {
        Deque<Integer> dQ = new ArrayDeque<>();
        dQ.offer(root);
        visited[root] = true;

        while (!dQ.isEmpty()) {
            int cur = dQ.pollFirst();
            for (int next : tree.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    dQ.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        findParents(1);
        for (int i = 2; i <= N; i++) sb.append(parent[i]).append("\n");
        System.out.print(sb);
    }
}
