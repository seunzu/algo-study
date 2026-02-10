package 실패율;

import java.util.*;

class Solution {
    static class Stage implements Comparable<Stage> {
        int idx;
        double fail;

        Stage(int idx, double fail) {
            this.idx = idx;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.fail < o.fail) return 1;
            if (this.fail > o.fail) return -1;
            return this.idx - o.idx;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N + 2];
        for (int s : stages) cnt[s]++;

        int players = stages.length;
        List<Stage> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double fail = 0.0;
            if (players > 0) fail = (double) cnt[i] / players;

            arr.add(new Stage(i, fail));
            players -= cnt[i];
        }

        Collections.sort(arr);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = arr.get(i).idx;
        }
        return ans;
    }
}