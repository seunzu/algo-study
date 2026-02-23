package gold.g3;

import java.io.*;
import java.util.*;

// 캐슬 디펜스
public class boj_17135 {
    static int N, M, D;
    static int[][] board;
    static int max = 0;

    static int dist (int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static void comb(int[] archers, int depth, int start) {
        if (depth == 3) {
            int[][] tmp = new int[N][M];
            for (int i = 0; i < N; i++) {
                tmp[i] = board[i].clone();
            }

            int result = simulate(tmp, archers);
            max = Math.max(max, result);
            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = i;
            comb(archers, depth + 1, i + 1);
        }
    }

    static int simulate(int[][] tmp, int[] archers) {
        int kill = 0;

        for (int turn = 0; turn < N; turn++) {
            Set<String> targets = new HashSet<>();

            for (int a : archers) {
                int minDist = Integer.MAX_VALUE;
                int targetR = -1;
                int targetC = -1;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (tmp[i][j] == 1) {
                            int d = dist(N, a, i, j);

                            if (d <= D) {
                                if (d < minDist || (d == minDist && j < targetC)) {

                                    minDist = d;
                                    targetR = i;
                                    targetC = j;
                                }
                            }
                        }
                    }
                }

                if (targetR != -1) {
                    targets.add(targetR + "," + targetC);
                }
            }

            for (String t : targets) {
                String[] sp = t.split(",");
                int r = Integer.parseInt(sp[0]);
                int c = Integer.parseInt(sp[1]);

                if (tmp[r][c] == 1) {
                    kill++;
                    tmp[r][c] = 0;
                }
            }

            for (int i = N - 1; i > 0; i--) {
                tmp[i] = tmp[i - 1];
            }
            tmp[0] = new int[M];
        }

        return kill;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(new int[3], 0, 0);

        System.out.println(max);
    }
}
