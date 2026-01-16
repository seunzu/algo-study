package silver.s1;

import java.io.*;
import java.util.*;

// 떡 먹는 호랑이
public class boj_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[D];

        for (int i = 1; i <= K / 2; i++) {
            for (int j = i + 1; j < K; j++) {
                arr[0] = i;
                arr[1] = j;

                for (int k = 2; k < D; k++) {
                    arr[k] = arr[k - 1] + arr[k - 2];
                }

                if (arr[D - 1] == K) {
                    System.out.println(arr[0]);
                    System.out.println(arr[1]);
                    return;
                }
            }
        }
    }
}
