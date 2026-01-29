package 그리디.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int ans = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] r : routes) {
            if (r[0] > camera) {
                camera = r[1];
                ans++;
            }
        }

        return ans;
    }
}