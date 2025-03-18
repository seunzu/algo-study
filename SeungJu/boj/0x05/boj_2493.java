package stack;

import java.io.*;
import java.util.*;

// 탑
public class boj_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < height) stack.pop();

            if (stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek()[0]).append(" ");

            stack.push(new int[]{i, height});
        }
        System.out.println(sb);
    }
}
