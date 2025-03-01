import java.util.*;

// 완주하지 못한 선수
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0)
                return key;
        }

        return answer;
    }
}