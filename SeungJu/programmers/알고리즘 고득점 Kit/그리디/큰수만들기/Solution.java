package 그리디.큰수만들기;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char n : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < n) {
                stack.pollLast();
                k--;
            }
            stack.addLast(n);
        }

        while (k-- > 0) stack.pollLast();

        for (char s : stack) sb.append(s);

        return sb.toString();
    }
}