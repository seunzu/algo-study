package 가장많이받은선물;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        Map<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HM.put(friends[i], i);
        }

        int[][] give = new int[n][n];
        for (String g : gifts) {
            String[] parts = g.split(" ");
            int from = HM.get(parts[0]);
            int to = HM.get(parts[1]);

            give[from][to]++;
        }

        int[] giftScore = new int[n];
        for (int i = 0; i < n; i++) {
            int giveCnt = 0;
            int receiveCnt = 0;

            for (int j = 0; j < n; j++) {
                giveCnt += give[i][j];
                receiveCnt += give[j][i];
            }

            giftScore[i] = giveCnt - receiveCnt;
        }

        int[] nextGift = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (give[i][j] > give[j][i]) nextGift[i]++;
                else if (give[i][j] < give[j][i]) nextGift[j]++;
                else {
                    if (giftScore[i] > giftScore[j]) nextGift[i]++;
                    else if (giftScore[i] < giftScore[j]) nextGift[j]++;
                }
            }
        }

        int maxCnt = 0;
        for (int next : nextGift) {
            maxCnt = Math.max(maxCnt, next);
        }

        return maxCnt;
    }
}