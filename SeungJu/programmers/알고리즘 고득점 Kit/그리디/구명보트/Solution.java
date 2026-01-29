package 그리디.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);

        int lt = 0;
        int rt = people.length - 1;
        while (lt <= rt) {
            if (people[lt] + people[rt] <= limit) lt++;
            rt--;
            ans++;
        }

        return ans;
    }
}