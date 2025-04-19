package DFSBFS.단어변환;

import java.util.*;

class Solution {
    public boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff> 1) return false;
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(begin);
        int steps = 0;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String curr = queue.poll();

                if (curr.equals(target)) return steps;

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && canConvert(curr, words[j])) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}