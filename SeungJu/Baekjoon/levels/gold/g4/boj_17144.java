package gold.g4;

import java.io.*;
import java.util.*;

// 미세먼지 안녕!
public class boj_17144 {
    static int R, C, T;
    static int[][] board;
    static int airTop, airBottom;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void spread() {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    int amount = board[i][j] / 5;
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (board[nx][ny] == -1) continue;
                        tmp[nx][ny] += amount;
                        cnt++;
                    }
                    board[i][j] -= amount * cnt;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] += tmp[i][j];
            }
        }
    }

    static void clean() {
        for (int i = airTop - 1; i > 0; i--) board[i][0] = board[i - 1][0];
        for (int j = 0; j < C - 1; j++) board[0][j] = board[0][j + 1];
        for (int i = 0; i < airTop; i++) board[i][C - 1] = board[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) board[airTop][j] = board[airTop][j - 1];
        board[airTop][1] = 0;

        for (int i = airBottom + 1; i < R - 1; i++) board[i][0] = board[i + 1][0];
        for (int j = 0; j < C - 1; j++) board[R - 1][j] = board[R - 1][j + 1];
        for (int i = R - 1; i > airBottom; i--) board[i][C - 1] = board[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) board[airBottom][j] = board[airBottom][j - 1];
        board[airBottom][1] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        airTop = airBottom = -1;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) {
                    if (airTop == -1) airTop = i;
                    else airBottom = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            clean();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    ans += board[i][j];
                }
            }
        }

        System.out.println(ans);
    }
}
