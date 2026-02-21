package gold.g2;

import java.io.*;
import java.util.*;

// 철로
public class boj_13334 {
    static class Line {
        long start, end;

        Line(long h, long o) {
            start = Math.min(h, o);
            end = Math.max(h, o);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Line> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long h = Long.parseLong(st.nextToken());
            long o = Long.parseLong(st.nextToken());
            arr.add(new Line(h, o));
        }

        long d = Long.parseLong(br.readLine());

        List<Line> valid = new ArrayList<>();
        for (Line l : arr) {
            if (l.end - l.start <= d) valid.add(l);
        }

        valid.sort(Comparator.comparingLong(l -> l.end));

        PriorityQueue<Long> pQ = new PriorityQueue<>();
        int ans = 0;
        for (Line l : valid) {
            pQ.offer(l.start);

            long lt = l.end - d;
            while (!pQ.isEmpty() && pQ.peek() < lt) pQ.poll();

            ans = Math.max(ans, pQ.size());
        }

        System.out.println(ans);
    }
}
