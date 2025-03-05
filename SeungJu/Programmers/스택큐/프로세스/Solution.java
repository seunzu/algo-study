import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == pq.peek()) {
                pq.poll();
                cnt++;
                if (cur[1] == location) {
                    return cnt;
                }
            } else {
                queue.add(cur);
            }
        }
        return cnt;
    }
}