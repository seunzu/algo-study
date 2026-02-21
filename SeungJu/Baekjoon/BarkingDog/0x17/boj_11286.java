package priorityQueue;

import java.io.*;
import java.util.*;

// 절댓값 힙
class AbsComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if (abs1 == abs2) return Integer.compare(o1, o2);
        else return abs1 - abs2;
    }
}

public class boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>(new AbsComparator());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                System.out.println(pQ.isEmpty() ? 0 : pQ.poll());
            } else pQ.offer(x);
        }
    }
}
