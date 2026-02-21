package simulation;

import java.io.*;
import java.util.*;

// 톱니바퀴
public class boj_14891 {
    static int[][] arr;
    static int K;

    static void spin(int idx, int dir) {
        if (dir == 1) {
            int temp = arr[idx][7];
            for (int i = 7; i > 0; i--) {
                arr[idx][i] = arr[idx][i - 1];
            }
            arr[idx][0] = temp;
        } else {
            int temp = arr[idx][0];
            for (int i = 0; i < 7; i++) {
                arr[idx][i] = arr[idx][i + 1];
            }
            arr[idx][7] = temp;
        }
    }

    static void rotate(int idx, int dir) {
        int[] dirs = new int[4];
        dirs[idx] = dir;

        for (int i = idx - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                dirs[i] = -dirs[i + 1];
            } else break;
        }

        for (int i = idx + 1; i < 4; i++) {
            if (arr[i - 1][2] != arr[i][6]) {
                dirs[i] = -dirs[i - 1];
            } else break;
        }

        for (int i = 0; i < 4; i++) {
            if (dirs[i] != 0) spin(i, dirs[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            rotate(num, dir);
        }

        int score = 0;
        if (arr[0][0] == 1) score += 1;
        if (arr[1][0] == 1) score += 2;
        if (arr[2][0] == 1) score += 4;
        if (arr[3][0] == 1) score += 8;

        System.out.println(score);
    }
}
