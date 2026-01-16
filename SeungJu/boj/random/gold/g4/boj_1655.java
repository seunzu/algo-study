package gold.g4;

import java.io.*;
import java.util.*;

// 가운데를 말해요
public class boj_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            maxHeap.offer(n);

            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.print(sb);
    }
}