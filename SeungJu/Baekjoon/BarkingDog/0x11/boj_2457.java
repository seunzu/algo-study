package greedy;

import java.io.*;
import java.util.*;

// 공주님의 정원
class Flower implements Comparable<Flower> {
    int start, end;

    public Flower(int sm, int sd, int em, int ed) {
        this.start = sm * 100 + sd;
        this.end = em * 100 + ed;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.start != o.start) return this.start - o.start;
        else return o.end - this.end;
    }
}

public class boj_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
        }

        Arrays.sort(flowers);

        int cnt = 0;
        int currEnd = 301;
        int idx = 0;

        while (currEnd <= 1130) {
            int maxEnd = currEnd;
            while (idx < N && flowers[idx].start <= currEnd) {
                if (flowers[idx].end > maxEnd) {
                    maxEnd = flowers[idx].end;
                }
                idx++;
            }
            if (maxEnd == currEnd) {
                System.out.println(0);
                return;
            }
            cnt++;
            currEnd = maxEnd;
        }

        System.out.println(cnt);
    }
}
