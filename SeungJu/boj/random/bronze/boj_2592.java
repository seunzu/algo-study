package bronze;

import java.io.*;
import java.util.*;

// 대표값
public class boj_2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> HM = new HashMap<>();
        int sum = 0;
        int freq = 0;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            HM.put(n, HM.getOrDefault(n, 0) + 1);
            sum += n;

            if (freq < HM.get(n)) {
                freq = HM.get(n);
                result = n;
            }
        }

        System.out.println(sum / 10 + "\n" + result);
    }
}
