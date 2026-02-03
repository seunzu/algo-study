package 동영상재생기;

class Solution {
    static int toTotalSec(String time) {
        String[] p = time.split(":");
        int m = Integer.parseInt(p[0]);
        int s = Integer.parseInt(p[1]);
        return m * 60 + s;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toTotalSec(video_len);
        int cur = toTotalSec(pos);
        int start = toTotalSec(op_start);
        int end = toTotalSec(op_end);

        if (start <= cur && cur <= end) cur = end;

        for (String c : commands) {
            if (c.equals("prev")) cur -= 10;
            else cur += 10;

            if (cur < 0) cur = 0;
            if (cur > len) cur = len;

            if (start <= cur && cur <= end) cur = end;
        }

        int m = cur / 60;
        int s = cur % 60;

        return String.format("%02d:%02d", m, s);
    }
}