package 할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            HM.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            if (map.equals(HM)) answer++;
        }

        return answer;
    }
}