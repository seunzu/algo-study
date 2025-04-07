package binarySearchTree;

import java.io.*;
import java.util.*;

// 이중 우선순위 큐
public class boj_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (str.equals("D")) {
                    if (map.isEmpty()) continue;

                    int key = (n == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }

            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}
