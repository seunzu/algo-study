import java.io.*;

// 1, 2, 3 더하기 5
public class boj_15990 {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int res = ((dp[N][1] + dp[N][2]) % MOD + dp[N][3]) % MOD;
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
