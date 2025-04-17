package 롤케이크자르기;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int count = 0;

        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];

            left.add(t);
            right.put(t, right.get(t) - 1);

            if (right.get(t) == 0) right.remove(t);
            if (left.size() == right.size()) count++;
        }

        return count;
    }
}