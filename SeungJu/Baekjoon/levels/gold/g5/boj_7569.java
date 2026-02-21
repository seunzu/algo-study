package gold.g5;

import java.io.*;
import java.util.*;

// 토마토
class Tomato {
    int z, x, y;

    public Tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class boj_7569 {
    static int M, N, H;
    static int[][][] map;
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static Queue<Tomato> q = new LinkedList<>();

    public static void bfs() {
        while (!q.isEmpty()) {
            Tomato cur = q.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nz = cur.z + dz[dir];
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if (map[nz][nx][ny] == 0) {
                    map[nz][nx][ny] = map[cur.z][cur.x][cur.y] + 1;
                    q.offer(new Tomato(nz, nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        q.offer(new Tomato(k, i, j));
                    }
                }
            }
        }

        bfs();

        int day = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, map[k][i][j]);
                }
            }
        }

        System.out.println(day - 1);
    }
}
