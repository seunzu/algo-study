package 숫자변환하기;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[y + 1];
        Arrays.fill(dist, -1);

        q.add(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == y) return dist[cur];

            if (cur + n <= y && dist[cur + n] == -1) {
                dist[cur + n] = dist[cur] + 1;
                q.add(cur + n);
            }

            if (cur * 2 <= y && dist[cur * 2] == -1) {
                dist[cur * 2] = dist[cur] + 1;
                q.add(cur * 2);
            }

            if (cur * 3 <= y && dist[cur * 3] == -1) {
                dist[cur * 3] = dist[cur] + 1;
                q.add(cur * 3);
            }
        }
        return -1;
    }
}