package gold;

import java.io.*;
import java.util.*;

// 말이 되고픈 원숭이
public class boj_1600 {
    static class Node {
        int x, y, k, dist;

        public Node(int x, int y, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == H - 1 && cur.y == W - 1) return cur.dist;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == 1) continue;
                if (!visited[nx][ny][cur.k]) {
                    visited[nx][ny][cur.k] = true;
                    q.offer(new Node(nx, ny, cur.k, cur.dist + 1));
                }
            }

            if (cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + hx[d];
                    int ny = cur.y + hy[d];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == 1) continue;
                    if (!visited[nx][ny][cur.k + 1]) {
                        visited[nx][ny][cur.k + 1] = true;
                        q.offer(new Node(nx, ny, cur.k + 1, cur.dist + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H][W][K + 1];
        System.out.println(bfs());
    }
}
