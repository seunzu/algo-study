package 성격유형검사하기;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> HM = new HashMap<>();
        for (char c : new char[]{'R','T','C','F','J','M','A','N'}) {
            HM.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) HM.put(first, HM.get(first) + (4 - choice));
            else HM.put(second, HM.get(second) + (choice - 4));
        }

        sb.append(HM.get('R') >= HM.get('T') ? 'R' : 'T');
        sb.append(HM.get('C') >= HM.get('F') ? 'C' : 'F');
        sb.append(HM.get('J') >= HM.get('M') ? 'J' : 'M');
        sb.append(HM.get('A') >= HM.get('N') ? 'A' : 'N');

        return sb.toString();
    }
}

