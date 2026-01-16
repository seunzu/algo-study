package silver.s4;

import java.io.*;
import java.util.*;

// 괄호
public class boj_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVps = true;

            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        isVps = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) isVps = false;
            sb.append(isVps ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
