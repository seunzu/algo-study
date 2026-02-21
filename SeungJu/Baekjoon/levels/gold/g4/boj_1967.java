package gold.g4;

import java.io.*;
import java.util.*;

// 트리의 지름
public class boj_1967 {
    static int n;
    static List<List<Node>> tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dfs(int cur, int dist) {
        visited[cur] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farNode = cur;
        }

        for (Node next : tree.get(cur)) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(p).add(new Node(c, w));
            tree.get(c).add(new Node(p, w));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }
}
