package gold;

import java.io.*;
import java.util.*;

// 팰린드롬?
public class boj_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) dp[i][i] = true;

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = true;
        }

        for (int len = 3; len <= N; len++) {
            for (int s = 1; s + len - 1 <= N; s++) {
                int e = s + len - 1;
                if (arr[s] == arr[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S][E] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }
}
