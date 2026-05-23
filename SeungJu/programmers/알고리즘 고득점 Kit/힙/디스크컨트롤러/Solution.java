package 힙.디스크컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int n = jobs.length;

        Queue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int time = 0, i = 0, cnt = 0, total = 0;

        while (cnt < n) {
            while (i < n && jobs[i][0] <= time) {
                pQ.offer(new int[]{jobs[i][1], jobs[i][0]});
                i++;
            }

            if (!pQ.isEmpty()) {
                int[] cur = pQ.poll();
                time += cur[0];
                total += time - cur[1];
                cnt++;
            } else time = jobs[i][0];
        }

        return total / n;
    }
}