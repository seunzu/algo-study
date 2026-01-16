package gold.g5;

import java.io.*;
import java.util.*;

// 수강 과목
public class boj_17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for (int t = N; t >= T; t--) {
                dp[t] = Math.max(dp[t], dp[t - T] + I);
            }
        }

        System.out.println(dp[N]);
    }
}
