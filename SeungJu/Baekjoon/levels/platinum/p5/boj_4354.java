package platinum.p5;

import java.io.*;

// 문자열 제곱
public class boj_4354 {
    static int[] getPi(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;

            int n = s.length();
            int[] pi = getPi(s);

            int len = n - pi[n - 1];
            if (n % len == 0) sb.append(n / len).append('\n');
            else sb.append(1).append('\n');
        }
        System.out.println(sb);
    }
}
