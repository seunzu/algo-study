package silver;

import java.io.*;
import java.util.*;

// 값이 k인 트리 노드의 깊이
public class boj_25511 {
    static int n, k;
    static List<List<Integer>> tree;
    static int[] arr;
    static int answer = -1;

    // ver1
    static void dfs(int cur, int depth) {
        if (answer != -1) return;

        if (arr[cur] == k) {
            answer = depth;
            return;
        }

        for (int next : tree.get(cur)) {
            dfs(next, depth + 1);
        }
    }

    // ver2
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if (arr[node] == k) return depth;

            for (int next : tree.get(node)) {
                q.add(new int[]{next, depth + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(p).add(c);
        }

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        dfs(0, 0);
//        System.out.println(answer);

        System.out.println(bfs());
    }
}
