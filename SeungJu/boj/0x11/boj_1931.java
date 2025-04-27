package greedy;

import java.io.*;
import java.util.*;

// 회의실 배정
class Time implements Comparable<Time> {
    public int start, end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}

public class boj_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Time[] meetings = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Time(start, end);
        }

        Arrays.sort(meetings);

        int cnt = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i].start >= endTime) {
                endTime = meetings[i].end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
