package LeetCode75.ArrayString;

// Kids With the Greatest Number of Candies
public class leetcode_1431 {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = 0;
            for (int c : candies) max = Math.max(max, c);

            List<Boolean> arr = new ArrayList<>();
            for (int c : candies) {
                arr.add(c + extraCandies >= max);
            }

            return arr;
        }
    }
}
