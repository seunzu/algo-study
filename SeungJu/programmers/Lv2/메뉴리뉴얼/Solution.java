package 메뉴리뉴얼;

import java.util.*;

class Solution {
    // 조합, 빈도
    static Map<String, Integer> HM;

    static void comb(char[] arr, int start, int len, StringBuilder sb) {
        if (sb.length() == len) {
            String com = sb.toString();
            HM.put(com, HM.getOrDefault(com, 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            comb(arr, i + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int c : course) {
            HM = new HashMap<>();
            int maxCnt = 0;

            for (String o : orders) {
                char[] arr = o.toCharArray();
                Arrays.sort(arr);
                comb(arr, 0, c, new StringBuilder());
            }

            for (int cnt : HM.values()) {
                if (cnt >= 2) {
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }

            for (String key : HM.keySet()) {
                if (HM.get(key) == maxCnt && maxCnt >= 2) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}