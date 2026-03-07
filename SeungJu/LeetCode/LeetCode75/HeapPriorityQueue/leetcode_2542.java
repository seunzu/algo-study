package LeetCode75.HeapPriorityQueue;

// Maximum Subsequence Score
public class leetcode_2542 {
    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;

            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                pairs[i][0] = nums1[i];
                pairs[i][1] = nums2[i];
            }

            Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

            PriorityQueue<Integer> pQ = new PriorityQueue<>();

            long sum = 0;
            long result = 0;

            for (int[] p : pairs) {
                pQ.offer(p[0]);
                sum += p[0];

                if (pQ.size() > k) sum -= pQ.poll();

                if (pQ.size() == k) {
                    result = Math.max(result, sum * p[1]);
                }
            }

            return result;
        }
    }
}
