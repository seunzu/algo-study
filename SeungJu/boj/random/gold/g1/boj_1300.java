package gold.g1;

import java.io.*;

// K번째 수
public class boj_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long lt = 1, rt = (long) N * N;
        long ans = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= k) {
                ans = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(ans);
    }
}
