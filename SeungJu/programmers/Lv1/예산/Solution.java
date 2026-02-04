package 예산;

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int cnt = 0;
        for (int n : d) {
            if (sum + n > budget) break;
            sum += n;
            cnt++;
        }

        return cnt;
    }
}
