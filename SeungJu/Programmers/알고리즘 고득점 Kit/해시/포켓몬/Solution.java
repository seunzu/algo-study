import java.util.*;

// 포켓몬
class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        return max > hs.size() ? hs.size() : max;
    }
}