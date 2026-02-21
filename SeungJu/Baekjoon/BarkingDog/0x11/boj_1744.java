package greedy;

import java.io.*;
import java.util.*;

// 수 묶기
public class boj_1744 {
    public static int calculate(PriorityQueue<Integer> pq) {
        int sum = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a * b;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        int ones = 0;
        int zeros = 0;

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) plusPQ.add(num);
            else if (num == 1) ones++;
            else if (num == 0) zeros++;
            else minusPQ.add(num);
        }

        int result = 0;
        result += calculate(plusPQ);
        if (!plusPQ.isEmpty()) result += plusPQ.poll();

        result += calculate(minusPQ);
        if (!minusPQ.isEmpty()) {
            if (zeros > 0) zeros--;
            else result += minusPQ.poll();
        }

        result += ones;

        System.out.println(result);
    }
}
