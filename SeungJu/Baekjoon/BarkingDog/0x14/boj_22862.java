package twoPointer;

import java.io.*;
import java.util.*;

// 가장 긴 짝수 연속한 부분 수열 (large)
public class boj_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int oddCnt = 0;
        int ans = 0;
        while (end < S) {
            if (arr[end] % 2 == 1) oddCnt++;

            while (oddCnt > N) {
                if (arr[start] % 2 == 1) oddCnt--;
                start++;
            }

            ans = Math.max(ans, (end - start + 1) - oddCnt);
            end++;
        }

        System.out.println(ans);
    }
}
