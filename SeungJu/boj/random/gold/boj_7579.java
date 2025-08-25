package gold;

import java.io.*;
import java.util.*;

// 앱
public class boj_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            sum += c[i];
        }

        int[] dp = new int[sum + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = sum; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[i] >= M) {
                ans = Math.min(ans, i);
            }
        }

        System.out.println(ans);
    }
}
