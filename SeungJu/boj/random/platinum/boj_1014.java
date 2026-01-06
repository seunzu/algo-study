package platinum;

import java.io.*;
import java.util.*;

// 컨닝
public class boj_1014 {
    static int N, M;
    static char[][] board;
    static int[][] dp;

    static boolean isValidState(int row, int state) {
        if ((state & (state << 1)) != 0) return false;

        for (int col = 0; col < M; col++) {
            if ((state & (1 << col)) != 0 && board[row][col] == 'x') {
                return false;
            }
        }
        return true;
    }

    static boolean isCompatible(int prev, int cur) {
        if (((cur << 1) & prev) != 0) return false;
        if (((cur >> 1) & prev) != 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int maxState = 1 << M;
            dp = new int[N][maxState];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }

            for (int state = 0; state < maxState; state++) {
                if (isValidState(0, state)) {
                    dp[0][state] = Integer.bitCount(state);
                }
            }

            for (int row = 1; row < N; row++) {
                for (int cur = 0; cur < maxState; cur++) {
                    if (!isValidState(row, cur)) continue;

                    int curCnt = Integer.bitCount(cur);
                    for (int prev = 0; prev < maxState; prev++) {
                        if (dp[row - 1][prev] == -1) continue;
                        if (isCompatible(prev, cur)) {
                            dp[row][cur] = Math.max(
                                    dp[row][cur],
                                    dp[row - 1][prev] + curCnt
                            );
                        }
                    }
                }
            }

            int ans = 0;
            for (int state = 0; state < maxState; state++) {
                ans = Math.max(ans, dp[N - 1][state]);
            }

            System.out.println(ans);
        }
    }
}
