package gold;

import java.io.*;
import java.util.*;

// 로봇 청소기
public class boj_14503 {
    static int N, M;
    static int[][] room;
    static int r, c, d;
    static int cleaned = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void simulate() {
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                cleaned++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            int backDir = (d + 2) % 4;
            int br = r + dr[backDir];
            int bc = c + dc[backDir];

            if (br < 0 || bc < 0 || br >= N || bc >= M || room[br][bc] == 1) break;
            else {
                r = br;
                c = bc;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        System.out.println(cleaned);
    }
}
