package platinum.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 김치
public class boj_11001 {
    static int N, D;
    static long[] T, V;
    static long answer = Long.MIN_VALUE;

    static void solution(int s, int e, int optl, int optr) {
        if (s > e) return;
        int mid = (s + e) / 2;
        int opt = optl;
        long max = Long.MIN_VALUE;

        for (int i = Math.max(optl, mid - D); i <= Math.min(optr, mid); i++) {
            long taste = (mid - i) * T[mid] + V[i];
            if (taste > max) {
                max = taste;
                opt = i;
            }
        }

        answer = Math.max(answer, max);

        solution(s, mid - 1, optl, opt);
        solution(mid + 1, e, opt, optr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        T = new long[N + 1];
        V = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) T[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) V[i] = Long.parseLong(st.nextToken());

        solution(1, N, 1, N);
        System.out.println(answer);
    }
}