package dataStructures.deque;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> HM = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            dq.addLast(x);
            HM.put(x, HM.getOrDefault(x, 0) + 1);

            if (dq.size() > m) {
                int removed = dq.pollFirst();
                HM.put(removed, HM.get(removed) - 1);

                if (HM.get(removed) == 0) HM.remove(removed);
            }

            if (dq.size() == m) {
                cnt = Math.max(cnt, HM.size());
            }
        }

        System.out.println(cnt);
    }
}
