import java.io.*;
import java.util.*;

// 동전 2
public class boj_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int INF = 10_001;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i : arr) {
            for (int j = i; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }

        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}
