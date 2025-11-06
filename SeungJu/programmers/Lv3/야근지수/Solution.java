package 야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pQ.offer(w);

        for (int i = 0; i < n ; i++) {
            if (pQ.isEmpty() || pQ.peek() == 0) break;
            pQ.offer(pQ.poll() - 1);
        }

        long sum = 0;
        while (!pQ.isEmpty()) {
            int i = pQ.poll();
            sum += i * i;
        }

        return sum;
    }
}