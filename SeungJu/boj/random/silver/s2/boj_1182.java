package silver.s2;

import java.io.*;
import java.util.*;

public class boj_1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int mask = 1; mask < (1 << N); mask++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) sum += nums[i];
            }

            if (sum == S) cnt++;
        }

        System.out.println(cnt);
    }
}