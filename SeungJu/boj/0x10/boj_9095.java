package dp;

import java.io.*;

public class boj_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n - 1]);
        }
    }
}
