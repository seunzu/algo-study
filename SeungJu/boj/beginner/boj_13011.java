import java.io.*;
import java.util.*;

// 사탕의 밀도
public class boj_13011 {
    static int N;
    static double[] C, W;

    public static double cost(double d) {
        double total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.abs(d * C[i] - W[i]);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        C = new double[N];
        W = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = Double.parseDouble(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Double.parseDouble(st.nextToken());
        }

        double low = 0.0, high = 1e6;
        for (int i = 0; i < 1000; i++) {
            double m1 = (2 * low + high) / 3;
            double m2 = (low + 2 * high) / 3;

            if (cost(m1) > cost(m2)) low = m1;
            else high = m2;
        }

        double d = (low + high) / 2;
        System.out.printf("%.9f\n", cost(d));
    }
}
