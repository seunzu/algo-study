import java.io.*;
import java.util.*;

// 공유기 설치
public class boj_2110 {
    static int N, C;
    static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);

        int lt = 1;
        int rt = x[N - 1] - x[0];
        int result = 0;

        while (lt <= rt) {
            int cnt = 1;
            int cur = x[0];
            int mid = (lt + rt) / 2;

            for (int i = 1; i < N; i++) {
                if (x[i] - cur >= mid) {
                    cnt++;
                    cur = x[i];
                }
            }

            if (cnt >= C) {
                result = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(result);
    }
}
