package diamond.d5;

import java.io.*;

// 제곱 ㄴㄴ
public class boj_1557 {
    static Long K;
    static int MAX = 50000;
    static int[] mu;
    static int[] primes;
    static int pc;
    static boolean[] isComp;

    static void mobiusSieve(int n) {
        mu = new int[n + 1];
        primes = new int[n + 1];
        isComp = new boolean[n + 1];

        mu[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!isComp[i]) {
                primes[pc++] = i;
                mu[i] = -1;
            }

            for (int j = 0; j < pc; j++) {
                int p = primes[j];
                long v = (long) i * p;
                if (v > n) break;
                int x = (int) v;
                isComp[x] = true;

                if (i % p == 0) {
                    mu[x] = 0;
                    break;
                } else mu[x] = -mu[i];
            }
        }
    }

    static long squareFreeCnt(long x) {
        long lim = (long) Math.sqrt(x);
        long sum = 0;

        for (int i = 1; i <= lim; i++) {
            if (mu[i] == 0) continue;
            sum += (long) mu[i] * (x / ((long) i * i));
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Long.parseLong(br.readLine());
        mobiusSieve(MAX);

        long lo = 1, hi = 2_100_000_000L;
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;

            if (squareFreeCnt(mid) >= K) hi = mid;
            else lo = mid + 1;
        }

        System.out.println(lo);
    }
}
