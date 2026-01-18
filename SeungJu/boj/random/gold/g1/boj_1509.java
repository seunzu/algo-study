package gold.g1;

import java.io.*;

// 팰린드롬 분할
public class boj_1509 {
    static final int INF = 1_000_000_000;
    static String s;
    static boolean[][] palindromes;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int n = s.length();
        palindromes = new boolean[n][n];

        for (int i = 0; i < n; i++) palindromes[i][i] = true;

        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromes[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1]) {
                    palindromes[i][j] = true;
                }
            }
        }

        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = INF;

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (palindromes[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
