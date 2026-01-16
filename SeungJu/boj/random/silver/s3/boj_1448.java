package silver.s3;

import java.io.*;
import java.util.*;

// 삼각형 만들기
public class boj_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int len = -1;
        for (int i = N - 1; i >= 2; i--) {
            int a = arr[i];
            int b = arr[i - 1];
            int c = arr[i - 2];

            if (b + c > a) {
                len = a + b + c;
                break;
            }
        }

        System.out.println(len);
    }
}
