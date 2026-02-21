package dataStructures.stack;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (char c : line.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        flag = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) flag = false;

            System.out.println(flag);
        }
    }
}
