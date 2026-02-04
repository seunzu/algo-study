package 폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        return max > set.size() ? set.size() : max;
    }
}