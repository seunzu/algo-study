package simulation;

import java.io.*;
import java.util.*;

// 2048 (Easy)
public class boj_12100 {
    static int N;
    static int[][] board;
    static int max = 0;

    static void dfs(int depth, int[][] currentBoard) {
        if (depth == 5) {
            max = Math.max(max, getMax(currentBoard));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = new int[N][N];

            for (int i = 0; i < N; i++) {
                nextBoard[i] = currentBoard[i].clone();
            }

            if (move(dir, nextBoard)) dfs(depth + 1, nextBoard);
        }
    }

    static boolean move(int dir, int[][] board) {
        boolean moved = false;

        if (dir == 0) { // 상
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int idx = 0;

                // 첫 번째로 숫자를 모은다.
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) temp[idx++] = board[i][j];
                }

                for (int i = 0; i < idx - 1; i++) {
                    if (temp[i] == temp[i + 1]) {
                        temp[i] *= 2;
                        temp[i + 1] = 0;
                        i++;
                    }
                }

                int newIdx = 0;
                for (int i = 0; i < N; i++) {
                    if (temp[i] != 0) {
                        board[newIdx++][j] = temp[i];
                        moved = true;
                    } else board[newIdx++][j] = 0;
                }
            }
        } else if (dir == 1) { // 하
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) temp[idx++] = board[i][j];
                }

                for (int i = 0; i < idx - 1; i++) {
                    if (temp[i] == temp[i + 1]) {
                        temp[i] *= 2;
                        temp[i + 1] = 0;
                        i++;
                    }
                }

                int newIdx = N - 1;
                for (int i = 0; i < N; i++) {
                    if (temp[i] != 0) {
                        board[newIdx--][j] = temp[i];
                        moved = true;
                    } else  board[newIdx--][j] = 0;
                }
            }
        } else if (dir == 2) { // 좌
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) temp[idx++] = board[i][j];
                }

                for (int j = 0; j < idx - 1; j++) {
                    if (temp[j] == temp[j + 1]) {
                        temp[j] *= 2;
                        temp[j + 1] = 0;
                        j++;
                    }
                }

                int newIdx = 0;
                for (int j = 0; j < N; j++) {
                    if (temp[j] != 0) {
                        board[i][newIdx++] = temp[j];
                        moved = true;
                    } else board[i][newIdx++] = 0;

                }
            }
        } else { // 우
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) temp[idx++] = board[i][j];
                }

                for (int j = 0; j < idx - 1; j++) {
                    if (temp[j] == temp[j + 1]) {
                        temp[j] *= 2;
                        temp[j + 1] = 0;
                        j++;
                    }
                }

                int newIdx = N - 1;
                for (int j = 0; j < N; j++) {
                    if (temp[j] != 0) {
                        board[i][newIdx--] = temp[j];
                        moved = true;
                    } else board[i][newIdx--] = 0;

                }
            }
        }
        return moved;
    }

    static int getMax(int[][] currentBoard) {
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxValue = Math.max(maxValue, currentBoard[i][j]);
            }
        }
        return maxValue;
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
        System.out.println(max);
    }
}
