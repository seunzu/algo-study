package gold.g5;

import java.io.*;
import java.util.*;

// 두 용액
public class boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0, rt = N - 1;
        int min = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (lt <= rt) {
            int sum = arr[lt] + arr[rt];
            int abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                ans1 = arr[lt];
                ans2 = arr[rt];
            }

            if (sum < 0) lt++;
            else rt--;
        }

        System.out.println(ans1 + " " + ans2);
    }
}
