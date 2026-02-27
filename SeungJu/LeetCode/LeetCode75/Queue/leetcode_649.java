package LeetCode75.Queue;

// Dota2 Senate
public class leetcode_649 {
    class Solution {
        public String predictPartyVictory(String senate) {
            int n = senate.length();

            Queue<Integer> radiant = new LinkedList<>();
            Queue<Integer> dire = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R') radiant.offer(i);
                else dire.offer(i);
            }

            while (!radiant.isEmpty() && !dire.isEmpty()) {
                int rIdx = radiant.poll();
                int dIdx = dire.poll();

                if (rIdx < dIdx) radiant.offer(rIdx + n);
                else dire.offer(dIdx + n);
            }

            return radiant.isEmpty() ? "Dire" : "Radiant";
        }
    }
}
