package LeetCode75.HeapPriorityQueue;

// Smallest Number in Infinite Set
public class leetcode_2336 {
    class SmallestInfiniteSet {
        int cur;
        PriorityQueue<Integer> pQ;
        Set<Integer> set;

        public SmallestInfiniteSet() {
            cur = 1;
            pQ = new PriorityQueue<>();
            set = new HashSet<>();
        }

        public int popSmallest() {
            if (!pQ.isEmpty()) {
                int val = pQ.poll();
                set.remove(val);
                return val;
            }

            return cur++;
        }

        public void addBack(int num) {
            if (num < cur && !set.contains(num)) {
                pQ.offer(num);
                set.add(num);
            }
        }
    }
}
