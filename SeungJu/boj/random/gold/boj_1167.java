package gold;

import java.io.*;
import java.util.*;

// 트리의 지름
public class boj_1167 {
    static int V;
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

        V = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree.get(from).add(new Node(to, weight));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }
}
