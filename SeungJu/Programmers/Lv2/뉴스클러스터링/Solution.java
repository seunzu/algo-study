package 뉴스클러스터링;

import java.util.*;

class Solution {
    public Map<String, Integer> getSubstrings(String str) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String key = "" + a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        return map;
    }

    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = getSubstrings(str1.toUpperCase());
        Map<String, Integer> map2 = getSubstrings(str2.toUpperCase());

        int intersection = 0;
        int union = 0;

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        for (String key : set) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            union += Math.max(count1, count2);
        }

        if (union == 0) return 65536;

        double jacquard = (double) intersection / union;
        return (int) (jacquard * 65536);
    }
}