package 스택큐.프로세스;

import java.util.*;

class Process {
    int priority;
    int idx;

    public Process(int priority, int idx) {
        this.priority = priority;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(priorities[i], i));
            pq.add(priorities[i]);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Process cur = q.poll();

            if (cur.priority == pq.peek()) {
                pq.poll();
                cnt++;

                if (cur.idx == location) return cnt;
            } else q.add(cur);
        }

        return cnt;
    }
}