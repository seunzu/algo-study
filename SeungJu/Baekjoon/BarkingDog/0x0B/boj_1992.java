package recursion;

import java.io.*;

// 쿼드트리
public class boj_1992 {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = size / 2;
        sb.append('(');
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                partition(row + i * newSize, col + j * newSize, newSize);
            }
        }
        sb.append(')');
    }

    public static boolean check(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != board[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }
}
