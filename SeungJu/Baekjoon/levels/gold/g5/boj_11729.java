package gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 탑 이동 순서
public class boj_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int mid, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, N) - 1);
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
}