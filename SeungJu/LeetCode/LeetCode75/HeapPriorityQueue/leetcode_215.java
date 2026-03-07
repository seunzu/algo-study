package LeetCode75.HeapPriorityQueue;

// Kth Largest Element in an Array
public class leetcode_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pQ = new PriorityQueue<>();
            for (int n : nums) {
                pQ.offer(n);

                if (pQ.size() > k) pQ.poll();
            }

            return pQ.peek();
        }
    }
}
