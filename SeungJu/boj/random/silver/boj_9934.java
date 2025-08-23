package silver;

import java.io.*;
import java.util.*;

// 완전 이진 트리
public class boj_9934 {
    static int K;
    static int[] tree;
    static List<List<Integer>> arr;

    static void search(int start, int end, int depth) {
        if (depth == K) {
            return;
        }

        int mid = (start + end) / 2;
        arr.get(depth).add(tree[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        tree = new int[(int) Math.pow(2, K) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            arr.add(new ArrayList<>());
        }

        search(0, tree.length - 1, 0);

        for (int i = 0; i < K; i++) {
            for (int j : arr.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

