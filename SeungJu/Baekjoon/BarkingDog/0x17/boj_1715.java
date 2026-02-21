package priorityQueue;

import java.io.*;
import java.util.*;

// 카드 정렬하기
public class boj_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>();
        while (N-- > 0) pQ.offer(Integer.parseInt(br.readLine()));

        int sum = 0;
        while (pQ.size() > 1) {
            int tmp = pQ.poll() + pQ.poll();
            sum += tmp;
            pQ.add(tmp);
        }
        System.out.println(sum);
    }
}
