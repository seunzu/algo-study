package gold.g1;

import java.io.*;
import java.util.*;

// 구슬 탈출 2
public class boj_13460 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] red = move(cur.rx, cur.ry, d);
                int[] blue = move(cur.bx, cur.by, d);

                int nrx = red[0], nry = red[1];
                int nbx = blue[0], nby = blue[1];

                boolean redHole = board[nrx][nry] == 'O';
                boolean blueHole = board[nbx][nby] == 'O';

                if (blueHole) continue;
                if (redHole) return cur.depth + 1;

                if (nrx == nbx && nry == nby) {
                    int redDist = Math.abs(cur.rx - nrx) + Math.abs(cur.ry - nry);
                    int blueDist = Math.abs(cur.bx - nbx) + Math.abs(cur.by - nby);

                    if (redDist > blueDist) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static int[] move(int x, int y, int dist) {
        while (board[x + dx[dist]][y + dy[dist]] != '#' && board[x][y] != 'O') {
            x += dx[dist];
            y += dy[dist];
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }
}
