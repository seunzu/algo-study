package greedy;

import java.io.*;
import java.util.*;

// 로프
public class boj_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int weight = arr[i] * (N - i);
            max = Math.max(max, weight);
        }

        System.out.println(max);
    }
}
