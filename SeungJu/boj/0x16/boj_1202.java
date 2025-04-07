package binarySearchTree;

import java.io.*;
import java.util.*;

// 보석 도둑
class Jewel implements Comparable<Jewel> {
    int weight, value;

    Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight;
    }
}

public class boj_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(jewels);
        Arrays.sort(arr);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j].weight <= arr[i]) {
                pQ.offer(jewels[j].value);
                j++;
            }

            if (!pQ.isEmpty()) total += pQ.poll();
        }

        System.out.println(total);
    }
}
