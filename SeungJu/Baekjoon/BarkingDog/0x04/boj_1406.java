package linkedList;

import java.io.*;
import java.util.*;

// 에디터
public class boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        String str = br.readLine();
        for (char ch : str.toCharArray()) left.push(ch);

        int N = Integer.parseInt(br.readLine());
        while(N--> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }

        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
