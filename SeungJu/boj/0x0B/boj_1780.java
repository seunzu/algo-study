package recursion;

import java.io.*;
import java.util.*;

// 종이의 개수
public class boj_1780 {
    static int[][] arr;
    static int[] count = new int[3];

    static void partition(int x, int y, int size) {
        if (check(x, y, size)) {
            count[arr[x][y] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                partition(x + dx * newSize, y + dy * newSize, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}
