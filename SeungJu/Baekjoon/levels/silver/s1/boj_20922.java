package silver.s1;

import java.io.*;
import java.util.*;

// 겹치는 건 싫어
public class boj_20922 {
    static int N, K;
    static int[] a;
    static int[] cnt = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        int max = 0;
        while (rt < N) {
            int num = a[rt];
            cnt[num]++;

            while (cnt[num] > K) {
                cnt[a[lt]]--;
                lt++;
            }

            max = Math.max(max, rt - lt + 1);
            rt++;
        }

        System.out.println(max);
    }
}
