package gold;

import java.io.*;
import java.util.*;

// 컨베이어 벨트 위의 로봇
public class boj_20055 {
    static int N, K;
    static int[] A;
    static boolean[] robots;
    static int step = 0;
    static int zeroCnt = 0;

    static void rotate() {
        int last = A[2 * N - 1];
        System.arraycopy(A, 0, A, 1, 2 * N - 1);
        A[0] = last;

        for (int i = N - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }

        robots[0] = false;
        robots[N - 1] = false;
    }

    static void move() {
        for (int i = N - 1; i > 0; i--) {
            if (robots[i - 1] && !robots[i] && A[i] > 0) {
                robots[i] = true;
                robots[i - 1] = false;
                A[i]--;
                if (A[i] == 0) zeroCnt++;
            }
        }
        robots[N - 1] = false;
    }

    static void put() {
        if (A[0] > 0) {
            robots[0] = true;
            A[0]--;
            if (A[0] == 0) zeroCnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        while (zeroCnt < K) {
            step++;
            rotate();
            move();
            put();
        }

        System.out.println(step);
    }
}
