package LeetCode75.BinarySearch;

// Guess Number Higher or Lower
public class leetcode_374 {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int lt = 1;
            int rt = n;

            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int result = guess(mid);

                if (result == 0) return mid;
                if (result == 1) lt = mid + 1;
                else rt = mid - 1;
            }

            return -1;
        }
    }
}
