package simulation;

import java.io.*;
import java.util.*;

// 스티커 붙이기
class Sticker {
    int R, C;
    int[][] shape;

    public Sticker(int R, int C, int[][] shape) {
        this.R = R;
        this.C = C;
        this.shape = shape;
    }

    public void rotate() {
        int[][] rotated = new int[C][R];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = shape[i][j];
            }
        }

        shape = rotated;
        int temp = R;
        R = C;
        C = temp;
    }
}

public class boj_18808 {
    static int N, M, K;
    static int[][] map;

    static boolean attachSticker(Sticker s) {
        for (int x = 0; x <= N - s.R; x++) {
            for (int y = 0; y <= M - s.C; y++) {
                if (canAttach(s, x, y)) {
                    doAttach(s, x, y);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canAttach(Sticker s, int x, int y) {
        for (int i = 0; i < s.R; i++) {
            for (int j = 0; j < s.C; j++) {
                if (s.shape[i][j] == 1 && map[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void doAttach(Sticker s, int x, int y) {
        for (int i = 0; i < s.R; i++) {
            for (int j = 0; j < s.C; j++) {
                if (s.shape[i][j] == 1) {
                    map[x + i][y + j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] shape = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    shape[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            Sticker sticker = new Sticker(R, C, shape);
            for (int r = 0; r < 4; r++) {
                if (attachSticker(sticker)) break;
                sticker.rotate();
            }
        }

        int count = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == 1) count++;
            }
        }

        System.out.println(count);
    }
}
