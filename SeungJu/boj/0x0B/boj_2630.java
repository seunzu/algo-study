package recursion;

import java.io.*;
import java.util.*;

// 색종이 만들기
public class boj_2630 {
    static int[][] board;
    static int white = 0, blue = 0;

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (board[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                partition(row + i * newSize, col + j * newSize, newSize);
            }
        }
//        partition(row, col, newSize);
//        partition(row, col + newSize, newSize);
//        partition(row + newSize, col, newSize);
//        partition(row +newSize, col + newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
