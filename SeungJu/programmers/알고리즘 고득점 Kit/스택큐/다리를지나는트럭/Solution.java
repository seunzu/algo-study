package 스택큐.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        int time = 0, total = 0;

        for (int i = 0; i < bridge_length; i++) {
            q.addLast(0);
        }

        for (int w : truck_weights) {
            while (total + w - q.peekFirst() > weight) {
                total -= q.pollFirst();
                q.addLast(0);
                time++;
            }

            total -= q.pollFirst();
            total += w;
            q.addLast(w);
            time++;
        }

        return time + bridge_length;
    }
}