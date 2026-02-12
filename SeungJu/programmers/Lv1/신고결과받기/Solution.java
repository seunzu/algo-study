package 신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] result = new int[n];

        Map<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HM.put(id_list[i], i);
        }

        Map<String, Set<String>> reportedBy = new HashMap<>();
        for (String r : report) {
            String[] str = r.split(" ");
            String from = str[0];
            String to = str[1];

            reportedBy
                    .computeIfAbsent(to, key -> new HashSet<>())
                    .add(from);
        }

        for (String reportedUser : reportedBy.keySet()) {
            Set<String> reporters = reportedBy.get(reportedUser);

            if (reporters.size() >= k) {
                for (String r : reporters) {
                    int idx = HM.get(r);
                    result[idx]++;
                }
            }
        }

        return result;
    }
}
