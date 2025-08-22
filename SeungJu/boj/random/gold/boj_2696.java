package gold;

import java.io.*;
import java.util.*;

// 중앙값 구하기
public class boj_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            int cnt = 0;
            List<Integer> arr = new ArrayList<>();

            Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> minHeap = new PriorityQueue<>();

            while (cnt < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()){
                    int num = Integer.parseInt(st.nextToken());
                    cnt++;

                    if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                        maxHeap.add(num);
                    } else minHeap.add(num);

                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.add(maxHeap.poll());
                    } else if (minHeap.size() > maxHeap.size()) {
                        maxHeap.add(minHeap.poll());
                    }

                    if (cnt % 2 == 1) {
                        arr.add(maxHeap.peek());
                    }
                }
            }

            sb.append(arr.size()).append("\n");
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i)).append(" ");
                if ((i + 1) % 10 == 0) sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
