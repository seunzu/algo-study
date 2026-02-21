package recursion;

import java.io.*;

// 별 찍기 - 11
public class boj_2448 {
    static char[][] board;

    public static void partition(int row, int col, int size) {
        if (size == 3) {
            board[row][col] = '*';
            board[row + 1][col - 1] = '*';
            board[row + 1][col + 1] = '*';
            for (int i = -2; i <= 2; i++) board[row + 2][col + i] = '*';
            return;
        }

        int newSize = size / 2;
        partition(row, col, newSize);
        partition(row + newSize, col - newSize, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        board = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                board[i][j] = ' ';
            }
        }

        partition(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
