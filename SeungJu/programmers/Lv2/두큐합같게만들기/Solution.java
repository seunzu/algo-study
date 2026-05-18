package 두큐합같게만들기;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int q : queue1) {
            q1.offer((long) q);
            sum1 += q;
        }

        for (int q : queue2) {
            q2.offer((long) q);
            sum2 += q;
        }

        long total = sum1 + sum2;

        if (total % 2 != 0) return -1;

        long target = total / 2;
        int cnt = 0;
        int limit = (queue1.length + queue2.length) * 3;

        while (cnt <= limit) {
            if (sum1 == target) return cnt;

            if (sum1 > target) {
                long n = q1.poll();

                sum1 -= n;
                sum2 += n;

                q2.offer(n);
            } else {
                long n = q2.poll();

                sum2 -= n;
                sum1 += n;

                q1.offer(n);
            }

            cnt++;
        }

        return -1;
    }
}