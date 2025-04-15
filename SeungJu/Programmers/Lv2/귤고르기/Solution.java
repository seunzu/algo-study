package 귤고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> arr = new ArrayList<>(map.values());
        arr.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i : arr) {
            sum += i;
            answer++;
            if (sum >= k) break;
        }

        return answer;
    }
}
