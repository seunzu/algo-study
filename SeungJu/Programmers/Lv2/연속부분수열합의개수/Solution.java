package 연속부분수열합의개수;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    sum += elements[(start + i) % n];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}