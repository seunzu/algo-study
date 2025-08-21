package silver;

import java.io.*;
import java.util.*;

// 완전 이진 트리
public class boj_9934 {
    static int K;
    static int[] arr;
    static List<List<Integer>> list;

    static void search(int start, int end, int depth) {
        if (depth == K) {
            return;
        }

        int mid = (start + end) / 2;
        list.get(depth).add(arr[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        arr = new int[(int) Math.pow(2, K) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        search(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

