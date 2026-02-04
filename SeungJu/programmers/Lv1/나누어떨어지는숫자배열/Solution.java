package 나누어떨어지는숫자배열;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int a : arr) {
            if (a % divisor == 0) list.add(a);
        }

        int[] ans = list.stream()
                .mapToInt(i -> i)
                .sorted()
                .toArray();

        return ans.length == 0 ? new int[]{-1} : ans;
    }
}
