package silver.s5;

import java.io.*;
import java.util.*;

// 투명
public class boj_1531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[101][101];

        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    board[i][j]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (board[i][j] > M) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
