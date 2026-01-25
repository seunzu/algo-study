import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (int s : set) ans[idx++] = s;

        Arrays.sort(ans);

        return ans;
    }
}