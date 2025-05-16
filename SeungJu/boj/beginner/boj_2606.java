import java.io.*;
import java.util.*;

// 바이러스
public class boj_2606 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        dfs(1);

        System.out.println(count);
    }
}
