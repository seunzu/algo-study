package recursion;

import java.io.*;
import java.util.*;

// 종이의 개수
public class boj_1780 {
    static int[][] board;
    static int[] count = new int[3];

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            count[board[row][col] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                partition(row + i * newSize, col + j * newSize, newSize);
            }
        }
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}
