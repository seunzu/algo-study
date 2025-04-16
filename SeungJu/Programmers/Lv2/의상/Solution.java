package 의상;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            HM.put(clothes[i][1], HM.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key : HM.keySet()) {
            answer *= (HM.get(key) + 1);
        }
        answer -= 1;

        return answer;
    }
}