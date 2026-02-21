package gold.g5;

import java.io.*;
import java.util.*;

// 평범한 배낭
public class boj_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int k = K; k >= W; k--) {
                dp[k] = Math.max(dp[k], dp[k - W] + V);
            }
        }

        System.out.println(dp[K]);
    }
}
