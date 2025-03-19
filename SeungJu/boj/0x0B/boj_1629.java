package recursion;

import java.io.*;
import java.util.*;

// 곱셈
public class boj_1629 {
    static long pow(long a, long b, long c) {
        if (b == 1) return a % c;

        long half = pow(a, b / 2, c);

        if (b % 2 == 0) return (half * half) % c;
        else return ((half * half) % c * a) % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }
}
