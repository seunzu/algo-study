package silver;

import java.io.*;
import java.util.*;

// 좋은 단어
public class boj_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else stack.push(c);
            }

            if (stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
