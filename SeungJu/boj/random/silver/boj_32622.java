package silver;

import java.io.*;
import java.util.*;

// 카드 뒤집기 게임
public class boj_32622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lt = new int[N + 1];
        lt[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == arr[i - 1]) {
                lt[i] = lt[i - 1] + 1;
            } else lt[i] = 1;
        }

        int[] rt = new int[N + 2];
        rt[N] = 1;
        for (int i = N - 1; i >= 1; i--) {
            if (arr[i] == arr[i + 1]) {
                rt[i] = rt[i + 1] + 1;
            } else rt[i] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, lt[i]);
        }

        for (int i = 1; i < N; i++) {
            if (1 - arr[i] == arr[i + 1]) {
                answer = Math.max(answer, lt[i] + rt[i + 1]);
            }
        }

        System.out.println(answer);
    }
}
