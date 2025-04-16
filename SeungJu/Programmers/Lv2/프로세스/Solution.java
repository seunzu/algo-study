package 프로세스;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            boolean flag = false;
            for (int[] q : queue) {
                if (q[0] > cur[0]) {
                    flag = true;
                    break;
                }
            }

            if (flag) queue.add(cur);
            else {
                count++;
                if (cur[1] == location) {
                    return count;
                }
            }
        }

        return count;
    }
}