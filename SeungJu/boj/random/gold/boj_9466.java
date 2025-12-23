package gold;

import java.io.*;
import java.util.*;

// 텀 프로젝트
public class boj_9466 {
    static int[] arr;
    static boolean[] visited, finished;
    static int cnt;

    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) dfs(next);
        else if (!finished[next]) {
            cnt++;
            for (int i = next; i != cur; i = arr[i]) {
                cnt++;
            }
        }

        finished[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(n - cnt).append('\n');
        }

        System.out.println(sb);
    }
}
