package platinum.p5;

import java.io.*;
import java.util.*;

// 숫자 맞추기
public class boj_2494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String from = br.readLine();
        String to = br.readLine();

        int[][] dp = new int[N + 1][10];
        int[][] arr = new int[N + 1][10];

        for (int[] i : dp) Arrays.fill(i, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            for (int rot = 0; rot < 10; rot++) {
                if (dp[i][rot] == Integer.MAX_VALUE) continue;

                int cur = (from.charAt(i) - '0' + rot) % 10;
                int target = to.charAt(i) - '0';

                int left = (target - cur + 10) % 10;
                int right = (cur - target + 10) % 10;

                int newRot = (rot + left) % 10;
                if (dp[i + 1][newRot] > dp[i][rot] + left) {
                    dp[i + 1][newRot] = dp[i][rot] + left;
                    arr[i + 1][newRot] = left;
                }

                if (dp[i + 1][rot] > dp[i][rot] + right) {
                    dp[i + 1][rot] = dp[i][rot] + right;
                    arr[i + 1][rot] = -right;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int lastRot = 0;
        for (int i = 0; i < 10; i++) {
            if (dp[N][i] < min) {
                min = dp[N][i];
                lastRot = i;
            }
        }
        sb.append(min).append('\n');

        Deque<String> result = new ArrayDeque<>();
        for (int i = N; i >= 1; i--) {
            int turn = arr[i][lastRot];
            result.addFirst(i + " " + turn);

            if (turn > 0) lastRot = (lastRot - turn + 10) % 10;
        }

        for (String s : result) sb.append(s).append('\n');

        System.out.print(sb);
    }
}