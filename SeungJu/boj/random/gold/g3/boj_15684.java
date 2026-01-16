package gold.g3;

import java.io.*;
import java.util.*;

// 사다리 조작
public class boj_15684 {
    static int N, M, H;
    static boolean[][] ladder;
    static int ans = 4;

    static void dfs(int cnt, int sr, int sc, int limit) {
        if (ans != 4) return;
        if (cnt == limit) {
            if (check()) ans = limit;
            return;
        }

        for (int r = sr; r <= H; r++) {
            int cStart = (r == sr ? sc : 1);
            for (int c = cStart; c < N; c++) {
                if (ladder[r][c]) continue;
                if (c - 1 >= 1 && ladder[r][c - 1]) continue;
                if (c + 1 < N && ladder[r][c + 1]) continue;

                ladder[r][c] = true;
                dfs(cnt + 1, r, c + 2, limit);
                ladder[r][c] = false;
            }
        }
    }

    static boolean check() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int r = 1; r <= H; r++) {
                if (pos < N && ladder[r][pos]) pos++;
                else if (pos > 1 && ladder[r][pos - 1]) pos--;
            }
            if (pos != start) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(0, 1, 1, i);
            if (ans != 4) break;
        }

        System.out.println(ans == 4 ? -1 : ans);
    }
}
