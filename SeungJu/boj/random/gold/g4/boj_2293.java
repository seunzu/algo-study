package gold.g4;

import java.io.*;
import java.util.*;

// 동전 1
public class boj_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i : arr) {
            for (int j = i; j <= k; j++) {
                dp[j] += dp[j - i];
            }
        }

        System.out.println(dp[k]);
    }
}
