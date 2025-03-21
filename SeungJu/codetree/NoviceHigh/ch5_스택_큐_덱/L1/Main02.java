package ch5_스택_큐_덱.L1;

import java.util.*;

// 괄호 문자열의 적합성 판단
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') s.push(c);
            else if (c == ')') {
                if (s.isEmpty()) {
                    System.out.println("No");
                    return;
                }
                s.pop();
            }
        }

        System.out.println(s.isEmpty() ? "Yes" : "No");
    }
}