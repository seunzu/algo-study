package gold;

import java.io.*;
import java.util.*;

// 문자열 폭발
public class boj_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();

        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stack.append(str.charAt(i));

            if (stack.length() >= len) {
                boolean flag = true;

                for (int j = 0; j < len; j++) {
                    if (stack.charAt(stack.length() - len + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    stack.delete(stack.length() - len, stack.length());
                }
            }
        }

        if (stack.length() == 0) System.out.println("FRULA");
        else System.out.println(stack);
    }
}
