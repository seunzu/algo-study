package 이분탐색.입국심사;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = 0;

        long lt = 0;
        long rt = (long) n * times[times.length - 1];
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum >= n) {
                rt = mid - 1;
                answer = mid;
            } else lt = mid + 1;
        }

        return answer;
    }
}