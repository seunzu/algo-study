package recursion;

import java.io.*;
import java.util.*;

// 하노이 탑 이동 순서
public class boj_11729 {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, K) - 1);
        hanoi(K, 1, 2, 3);
        System.out.println(sb);
    }
}
