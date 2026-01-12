package 택배상자;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> sub = new ArrayDeque<>();
        int idx = 0;
        int box = 0;
        int n = order.length;

        while (box <= n) {
            if (order[idx] == box) {
                idx++;
                box++;
            } else if (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                idx++;
            } else {
                sub.push(box);
                box++;
            }
        }

        while (!sub.isEmpty() && idx < n && sub.peek() == order[idx]) {
            sub.pop();
            idx++;
        }

        return idx;
    }
}
