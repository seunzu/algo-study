package gold.g3;

import java.io.*;
import java.util.*;

// 소용돌이 예쁘게 출력하기
public class boj_1022 {
    static int r1, c1, r2, c2;
    static int[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void fillSpiral() {
        int x = 0, y = 0;
        int num = 1;
        int dir = 0;

        if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
            board[x - r1][y - c1] = num;
        }

        int maxDist = Math.max(Math.max(Math.abs(r1), Math.abs(r2)),
                Math.max(Math.abs(c1), Math.abs(c2)));

        int steps = 1;
        num++;

        while (steps <= maxDist * 2 + 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    x += dx[dir];
                    y += dy[dir];

                    if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                        board[x - r1][y - c1] = num;
                    }
                    num++;
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        board = new int[r2 - r1 + 1][c2 - c1 + 1];

        fillSpiral();

        int maxValue = 0;
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                maxValue = Math.max(maxValue, board[i][j]);
            }
        }

        int maxLen = String.valueOf(maxValue).length();
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                String format = "%" + maxLen + "d";
                sb.append(String.format(format, board[i][j]));
                if (j < c2 - c1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}