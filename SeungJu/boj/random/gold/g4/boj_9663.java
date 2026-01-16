package gold.g4;

import java.io.*;

// N-Queen
public class boj_9663 {
    static int N;
    static int[] arr;
    static int cnt = 0;

    static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isSafe(depth)) dfs(depth + 1);
        }
    }

    static boolean isSafe(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth] || Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);

        System.out.println(cnt);
    }
}
