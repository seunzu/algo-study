package gold;

import java.io.*;
import java.util.*;

// 2048 (Easy)
public class boj_12100 {
    static int N;
    static int[][] board;
    static int answer = 0;

    static void dfs(int depth, int[][] curBoard) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, curBoard[i][j]);
                }
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] nextBoard = move(curBoard, d);
            dfs(depth + 1, nextBoard);
        }
    }

    static int[][] move(int[][] arr, int d) {
        int[][] newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i].clone();
        }

        switch (d) {
            case 0: return moveUp(newArr);
            case 1: return moveDown(newArr);
            case 2: return moveLeft(newArr);
            case 3: return moveRight(newArr);
        }
        return newArr;
    }

    static int[][] moveLeft(int[][] arr) {
        int[][] res = new int[N][N];

        for (int r = 0; r < N; r++) {
            int idx = 0;
            int prev = 0;

            for (int c = 0; c < N; c++) {
                if (arr[r][c] == 0) continue;

                if (prev == 0) prev = arr[r][c];
                else if (prev == arr[r][c]) {
                    res[r][idx++] = prev * 2;
                    prev = 0;
                } else {
                    res[r][idx++] = prev;
                    prev = arr[r][c];
                }
            }
            if (prev != 0) res[r][idx] = prev;
        }
        return res;
    }

    static int[][] moveRight(int[][] arr) {
        int[][] res = new int[N][N];

        for (int r = 0; r < N; r++) {
            int idx = N - 1;
            int prev = 0;

            for (int c = N - 1; c >= 0; c--) {
                if (arr[r][c] == 0) continue;

                if (prev == 0) {
                    prev = arr[r][c];
                } else if (prev == arr[r][c]) {
                    res[r][idx--] = prev * 2;
                    prev = 0;
                } else {
                    res[r][idx--] = prev;
                    prev = arr[r][c];
                }
            }
            if (prev != 0) res[r][idx] = prev;
        }
        return res;
    }

    static int[][] moveUp(int[][] arr) {
        int[][] res = new int[N][N];

        for (int c = 0; c < N; c++) {
            int idx = 0;
            int prev = 0;

            for (int r = 0; r < N; r++) {
                if (arr[r][c] == 0) continue;

                if (prev == 0) {
                    prev = arr[r][c];
                } else if (prev == arr[r][c]) {
                    res[idx++][c] = prev * 2;
                    prev = 0;
                } else {
                    res[idx++][c] = prev;
                    prev = arr[r][c];
                }
            }
            if (prev != 0) res[idx][c] = prev;
        }
        return res;
    }

    static int[][] moveDown(int[][] arr) {
        int[][] res = new int[N][N];

        for (int c = 0; c < N; c++) {
            int idx = N - 1;
            int prev = 0;

            for (int r = N - 1; r >= 0; r--) {
                if (arr[r][c] == 0) continue;

                if (prev == 0) {
                    prev = arr[r][c];
                } else if (prev == arr[r][c]) {
                    res[idx--][c] = prev * 2;
                    prev = 0;
                } else {
                    res[idx--][c] = prev;
                    prev = arr[r][c];
                }
            }
            if (prev != 0) res[idx][c] = prev;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(answer);
    }
}
