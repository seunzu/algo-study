package linkedList;

import java.io.*;
import java.util.*;

// 키로거
public class boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (char c : str.toCharArray()) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }

            while (!left.isEmpty()) right.push(left.pop());
            while (!right.isEmpty()) sb.append(right.pop());
            System.out.println(sb);
        }
    }
}
