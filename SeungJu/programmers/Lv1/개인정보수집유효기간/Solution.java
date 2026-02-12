package 개인정보수집유효기간;

import java.util.*;

class Solution {
    static int convert(String date) {
        String[] d = date.split("\\.");
        int y = Integer.parseInt(d[0]);
        int m = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        return y * 12 * 28 + m * 28 + day;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> HM = new HashMap<>();
        for (String t : terms) {
            String[] parts = t.split(" ");
            HM.put(parts[0], Integer.parseInt(parts[1]));
        }

        int todayDay = convert(today);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int startDay = convert(parts[0]);
            int expireDay = startDay + HM.get(parts[1]) * 28;

            if (expireDay <= todayDay) {
                arr.add(i + 1);
            }
        }

        return arr.stream().mapToInt(i -> i).toArray();
    }
}