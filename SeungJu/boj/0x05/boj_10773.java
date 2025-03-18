package stack;

import java.io.*;
import java.util.*;

// 제로
public class boj_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) stack.pop();
            else stack.push(n);
        }

        int answer = 0;
        while (!stack.isEmpty()) answer += stack.pop();
        System.out.println(answer);
    }
}
