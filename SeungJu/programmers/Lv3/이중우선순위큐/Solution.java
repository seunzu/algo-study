package 이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minPQ.offer(num);
                maxPQ.offer(num);
            } else if (command.equals("D")) {
                if (minPQ.isEmpty()) continue;

                if (num == 1) minPQ.remove(maxPQ.poll());
                else maxPQ.remove(minPQ.poll());
            }
        }

        if (maxPQ.isEmpty()) return new int[] {0, 0};
        else return new int[] {maxPQ.poll(), minPQ.poll()};
    }
}