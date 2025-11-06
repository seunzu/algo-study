package 그리디.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve) reserveSet.add(r);

        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                answer++;
                reserveSet.remove(l);
            } else {
                lostList.add(l);
            }
        }

        for (int l : lostList) {
            if (reserveSet.contains(l - 1)) {
                answer++;
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                answer++;
                reserveSet.remove(l + 1);
            }
        }

        return answer;
    }
}