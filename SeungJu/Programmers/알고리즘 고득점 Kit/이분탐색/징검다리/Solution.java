package 이분탐색.징검다리;

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int lt = 1;
        int rt = distance;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int cnt = 0;
            int prev = 0;
            for (int rock : rocks) {
                if (rock - prev < mid) cnt++;
                else prev = rock;
            }

            if (distance - prev < mid) cnt++;

            if (cnt <= n) {
                lt = mid + 1;
                answer = mid;
            } else rt = mid - 1;
        }

        return answer;
    }
}