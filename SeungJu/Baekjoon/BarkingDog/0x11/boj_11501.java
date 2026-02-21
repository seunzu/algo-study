package greedy;

import java.io.*;
import java.util.*;

// 주식
public class boj_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[N - 1];
            long result = 0;
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) result += max - arr[i];
                else max = arr[i];
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
