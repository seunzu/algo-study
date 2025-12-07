package gold;

import java.io.*;
import java.util.*;

// 리모컨
public class boj_1107 {
    static int N, M;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean flag = true;

            for (int j = 0; j < s.length(); j++) {
                if (broken[s.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }

            if (!flag) continue;

            int press = s.length() + Math.abs(N - i);
            ans = Math.min(ans, press);
        }

        System.out.println(ans);
    }
}
