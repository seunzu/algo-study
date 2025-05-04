package greedy;

import java.io.*;

// 게임을 만든 동준이
public class boj_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                int diff = arr[i] - (arr[i + 1] - 1);
                cnt += diff;
                arr[i] = arr[i + 1] - 1;
            }
        }

        System.out.println(cnt);
    }
}
