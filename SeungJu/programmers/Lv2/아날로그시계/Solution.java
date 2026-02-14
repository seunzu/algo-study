package 아날로그시계;

class Solution {
    public long cnt(long t) {
        return (t * 59) / 3600 + (t * 719) / 43200 - (t / 43200);
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long start = h1 * 3600L + m1 * 60L + s1;
        long end   = h2 * 3600L + m2 * 60L + s2;

        long result = cnt(end) - cnt(start);

        if ((start * 59) % 3600 == 0 || (start * 719) % 43200 == 0) result++;

        return (int) result;
    }
}