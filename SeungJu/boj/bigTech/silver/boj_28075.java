package silver;

import java.io.*;
import java.util.*;

// 스파이
public class boj_28075 {
    static int N, M;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = new int[2][3];
        st = new StringTokenizer(br.readLine() + " " + br.readLine());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[N + 1][3][M + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int val = score[i][j];
                dp[1][j][Math.min(M, val)]++;
            }
        }

        for (int day = 1; day < N; day++) {
            for (int j = 0; j < 3; j++) {
                for (int sum = 0; sum <= M; sum++) {
                    if (dp[day][j][sum] == 0) continue;

                    for (int i = 0; i < 2; i++) {
                        for (int next = 0; next < 3; next++) {
                            int val = score[i][next];
                            if (next == j) val /= 2;

                            int nextSum = Math.min(M, sum + val);
                            dp[day + 1][next][nextSum] += dp[day][j][sum];
                        }
                    }
                }
            }
        }

        long cnt = 0;
        for (int j = 0; j < 3; j++) {
            cnt += dp[N][j][M];
        }

        System.out.println(cnt);
    }
}
