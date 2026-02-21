package tree;

import java.io.*;
import java.util.*;

// 노드사이의 거리
public class boj_1240 {
    static List<List<Node>> tree;
    static boolean[] visited;
    static int answer;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dfs(int current, int target, int sum) {
        if (current == target) {
            answer = sum;
            return;
        }

        visited[current] = true;

        for (Node next : tree.get(current)) {
            if (!visited[next.to]) {
                dfs(next.to, target, sum + next.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree.get(u).add(new Node(v, w));
            tree.get(v).add(new Node(u, w));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            answer = 0;
            dfs(a, b, 0);
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
