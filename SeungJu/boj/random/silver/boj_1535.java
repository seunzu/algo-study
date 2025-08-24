package silver;

import java.io.*;
import java.util.*;

// 안녕
public class boj_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        int[] J = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];

        for (int i = 1; i <= N; i++) {
            for (int j = 99; j >= L[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
