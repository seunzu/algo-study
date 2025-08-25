package bronze;

import java.io.*;

// 알고리즘 수업 - 피보나치 수 1
public class boj_24416 {
    static int cnt1 = 0;
    static int cnt2 = 0;

    static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        } else return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            cnt2++;
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(cnt1 + " " + cnt2);
    }
}
