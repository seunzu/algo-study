package gold;

import java.io.*;
import java.util.*;

// 램프
public class boj_1034 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        Map<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String row = arr[i];

            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '0') cnt++;
            }

            if (cnt <= K && (K - cnt) % 2 == 0) {
                HM.put(row, HM.getOrDefault(row, 0) + 1);
            }
        }

        int ans = 0;
        for (int v : HM.values()) {
            ans = Math.max(ans, v);
        }

        System.out.println(ans);
    }
}
