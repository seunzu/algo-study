package silver.s4;

import java.io.*;
import java.util.*;

// 30
public class boj_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        char[] arr = N.toCharArray();
        Arrays.sort(arr);

        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sb.append(num);
            sum += num;
        }

        if (sum % 3 != 0 || arr[0] != '0') {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}
