package 오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // userId, nickname
        Map<String, String> HM = new HashMap<>();
        // userId, word
        List<String[]> logs = new ArrayList<>();

        for (String r : record) {
            String[] str = r.split(" ");
            String word = str[0];

            if (word.equals("Enter")) {
                HM.put(str[1], str[2]);
                logs.add(new String[]{str[1], "Enter"});
            } else if (word.equals("Leave")) {
                logs.add(new String[]{str[1], "Leave"});
            } else HM.put(str[1], str[2]);
        }

        String[] result = new String[logs.size()];
        int idx = 0;
        for (String[] l : logs) {
            String word = l[1];
            String nickname = HM.get(l[0]);

            if (word.equals("Enter")) {
                result[idx++] = nickname + "님이 들어왔습니다.";
            } else {
                result[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return result;
    }
}