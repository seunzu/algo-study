package platinum;

import java.io.*;
import java.util.*;

// 히스토그램에서 가장 큰 직사각형
public class boj_6549 {
    static int n;

    static long getMax(long[] h) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                long height = h[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = h[stack.pop()];
            long width = stack.isEmpty() ? n : n - stack.peek() - 1;
            max = Math.max(max, height * width);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long[] h = new long[n];
            for (int i = 0; i < n; i++) {
                h[i] = Long.parseLong(st.nextToken());
            }

            long max = getMax(h);

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
