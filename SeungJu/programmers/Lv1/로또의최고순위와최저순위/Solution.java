package 로또의최고순위와최저순위;

class Solution {
    static int getRank(int match) {
        switch (match) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int matchCnt = 0;

        boolean[] win = new boolean[46];
        for (int w : win_nums) win[w] = true;

        for (int l : lottos) {
            if (l == 0) zeroCnt++;
            else if (win[l]) matchCnt++;
        }

        int maxRank = getRank(matchCnt + zeroCnt);
        int minRank = getRank(matchCnt);

        return new int[]{maxRank, minRank};
    }
}