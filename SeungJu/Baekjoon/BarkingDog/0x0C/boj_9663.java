package backtracking;

import java.io.*;

// N-Queen
// 퀸: 상하좌우, 대각선
public class boj_9663 {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPossible(depth, i)) {
                arr[depth] = i;
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth, int col) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == col) return false;
            if (Math.abs(depth - i) == Math.abs(col - arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }
}
