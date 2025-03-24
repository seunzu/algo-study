package backtracking;

import java.io.*;
import java.util.*;

// N과 M (2)
public class boj_15650 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int val : arr) sb.append(val).append(" ");
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }
}
