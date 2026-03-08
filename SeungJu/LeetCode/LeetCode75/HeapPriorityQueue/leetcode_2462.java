package LeetCode75.HeapPriorityQueue;

// Total Cost to Hire K Workers
public class leetcode_2462 {
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Integer> ltHeap = new PriorityQueue<>();
            PriorityQueue<Integer> rtHeap = new PriorityQueue<>();

            int lt = 0;
            int rt = costs.length - 1;

            for (int i = 0; i < candidates && lt <= rt; i++) {
                ltHeap.offer(costs[lt++]);
            }

            for (int i = 0; i < candidates && lt <= rt; i++) {
                rtHeap.offer(costs[rt--]);
            }

            long total = 0;

            for (int i = 0; i < k; i++) {
                int ltMin = ltHeap.isEmpty() ? Integer.MAX_VALUE : ltHeap.peek();
                int rtMin = rtHeap.isEmpty() ? Integer.MAX_VALUE : rtHeap.peek();

                if (ltMin <= rtMin) {
                    total += ltHeap.poll();
                    if (lt <= rt) ltHeap.offer(costs[lt++]);
                } else {
                    total += rtHeap.poll();
                    if (lt <= rt) rtHeap.offer(costs[rt--]);
                }
            }

            return total;
        }
    }
}
