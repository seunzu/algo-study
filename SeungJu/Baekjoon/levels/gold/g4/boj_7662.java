package gold.g4;

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
                String[] str = br.readLine().split(" ");
                String cmd = str[0];
                int num = Integer.parseInt(str[1]);

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }

            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}
