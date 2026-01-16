package gold.g5;

import java.io.*;
import java.util.*;

// 괄호의 값
public class boj_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '(') answer += tmp;
                stack.pop();
                tmp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '[') answer += tmp;
                stack.pop();
                tmp /= 3;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : answer);
    }
}
