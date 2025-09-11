package silver;

import java.io.*;
import java.util.*;

// 회전 초밥
public class boj_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            sushi[N + i] = sushi[i];
        }

        int[] cnt = new int[d + 1];

        int kind = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[sushi[i]] == 0) kind++;
            cnt[sushi[i]]++;
        }

        int ans = kind + (cnt[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            if (--cnt[sushi[i - 1]] == 0) kind--;
            if (cnt[sushi[i + k - 1]]++ == 0) kind++;
            ans = Math.max(ans, kind + (cnt[c] == 0 ? 1 : 0));
        }

        System.out.println(ans);
    }
}
