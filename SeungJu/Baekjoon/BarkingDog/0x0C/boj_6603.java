package backtracking;

import java.io.*;
import java.util.*;

// 로또
public class boj_6603 {
    static int[] arr = new int[6];
    static int k;
    static int[] S;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int at, int depth) {
        if (depth == 6) {
            for (int val : arr) sb.append(val).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = at; i < k; i++) {
            arr[depth] = S[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
