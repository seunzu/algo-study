package recursion;

import java.io.*;

// 별 찍기 - 10
public class boj_2447 {
    static char[][] map;

    public static void printStar(int x, int y, int size) {
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        int next = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                printStar(x + i * next, y + j * next, next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = ' ';
            }
        }

        printStar(0, 0, N);
        for (char[] row : map) {
            for (char c : row) sb.append(c);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
