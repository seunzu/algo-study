package gold.g4;

import java.io.*;
import java.util.*;

// 최소 스패닝 트리
class Node implements Comparable<Node> {
    int from, to, weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class boj_1197 {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node> arr = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr.add(new Node(A, B, C));
        }

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Collections.sort(arr);

        int total = 0;
        for (Node node : arr) {
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                total += node.weight;
            }
        }

        System.out.println(total);
    }
}
