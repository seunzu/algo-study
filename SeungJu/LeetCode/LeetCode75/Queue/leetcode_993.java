package LeetCode75.Queue;

// Number of Recent Calls
public class leetcode_993 {
    class RecentCounter {
        static Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.offer(t);

            while (!q.isEmpty() && q.peek() < t - 3000) {
                q.poll();
            }

            return q.size();
        }
    }
}
