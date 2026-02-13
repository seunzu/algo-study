package 퍼즐게임챌린지;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lt = 1;
        int rt = 100000;
        int ans = rt;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long total = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) total += times[i];
                else {
                    int fail = diffs[i] - mid;
                    total += times[i] + (long) fail * (times[i] + times[i - 1]);
                }

                if (total > limit) break;
            }

            if (total <= limit) {
                ans = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return ans;
    }
}