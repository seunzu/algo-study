package gold.g2;

import java.io.*;
import java.util.*;

// 후위 표기식
public class boj_1918 {
    static int priority(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') sb.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
