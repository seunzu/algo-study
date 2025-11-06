package 전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> HM = new HashMap<>();

        int idx = 0;
        for (String n : phone_book) HM.put(n, idx++);

        for (String n : phone_book) {
            for (int i = 0; i < n.length(); i++) {
                if (HM.containsKey(n.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}