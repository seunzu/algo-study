package gold;

import java.io.*;
import java.util.*;

// 파일 합치기
public class boj_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int[] arr = new int[K + 1];
            int[] prefix = new int[K + 1];
            long[][] dp = new long[K + 1][K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + arr[i];
            }

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Long.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        long cost = dp[i][k] + dp[k + 1][j] + (prefix[j] - prefix[i - 1]);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            sb.append(dp[1][K]).append('\n');
        }

        System.out.println(sb);
    }
}
