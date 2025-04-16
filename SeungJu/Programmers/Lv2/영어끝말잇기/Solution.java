package 영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            boolean invalid = !set.add(cur) ||
                    prev.charAt(prev.length() - 1) != cur.charAt(0);
            if (invalid) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{player, turn};
            }
        }

        return new int[]{0, 0};
    }
}