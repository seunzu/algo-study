package gold;

import java.io.*;
import java.util.*;

// 구슬 탈출
public class boj_13459 {
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

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] move(int x, int y, int dx, int dy) {
        int moveCnt = 0;

        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            moveCnt++;
        }

        return new int[]{x, y, moveCnt};
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth >= 10) return 0;

            for (int d = 0; d < 4; d++) {
                int[] rmove = move(cur.rx, cur.ry, dx[d], dy[d]);
                int[] bmove = move(cur.bx, cur.by, dx[d], dy[d]);

                int nrx = rmove[0];
                int nry = rmove[1];
                int nbx = bmove[0];
                int nby = bmove[1];

                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O') return 1;

                if (nrx == nbx && nry == nby) {
                    if (rmove[2] > bmove[2]) {
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
        return 0;
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
                    rx = i;
                    ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }
}
