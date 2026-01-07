package platinum;

import java.io.*;

// 불 끄기
public class boj_14939 {
    static final int N = 10;
    static char[][] origin = new char[N][N];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, -1, 1, 0, 0};
    static int ans = Integer.MAX_VALUE;

    static void press(char[][] board, int x, int y) {
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            board[nx][ny] = (board[nx][ny] == 'O') ? '#' : 'O';
        }
    }

    static boolean check(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') return false;
            }
        }
        return true;
    }

    static char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[N][N];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine().toCharArray();
        }

        for (int mask = 0; mask < (1 << N); mask++) {
            char[][] board = copyBoard(origin);
            int cnt = 0;

            for (int col = 0; col < N; col++) {
                if ((mask & (1 << col)) != 0) {
                    press(board, 0, col);
                    cnt++;
                }
            }

            for (int row = 1; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[row - 1][col] == 'O') {
                        press(board, row, col);
                        cnt++;
                    }
                }
            }

            if (check(board)) ans = Math.min(ans, cnt);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}