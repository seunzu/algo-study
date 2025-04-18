package 스택큐.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int n : arr) {
            if (stack.isEmpty() || !stack.peek().equals(n))
                stack.push(n);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}