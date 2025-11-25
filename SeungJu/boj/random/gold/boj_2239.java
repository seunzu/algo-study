package gold;

import java.io.*;
import java.util.*;

// 스도쿠
public class boj_2239 {
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] board = new int[9][9];
    static List<Pos> empty = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(int idx) {
        if (idx == empty.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        Pos p = empty.get(idx);
        int r = p.r;
        int c = p.c;

        for (int num = 1; num <= 9; num++) {
            if (check(r, c, num)) {
                board[r][c] = num;
                dfs(idx + 1);
                board[r][c] = 0;
            }
        }
    }

    static boolean check(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) return false;
        }

        int br = (r / 3) * 3;
        int bc = (c / 3) * 3;

        for (int i = br; i < br + 3; i++) {
            for (int j = bc; j < bc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 9; r++) {
            String str = br.readLine();
            for (int c = 0; c < 9; c++) {
                board[r][c] = str.charAt(c) - '0';
                if (board[r][c] == 0) {
                    empty.add(new Pos(r, c));
                }
            }
        }

        dfs(0);
    }
}
