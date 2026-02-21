package stack;

import java.io.*;
import java.util.*;

// 스택 수열
public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        while (N--> 0) {
            int M = Integer.parseInt(br.readLine());

            while (start < M) {
                stack.push(++start);
                sb.append("+\n");
            }

            if (stack.pop() != M) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
