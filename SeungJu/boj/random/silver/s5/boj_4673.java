package silver.s5;

import java.io.*;

// 셀프 넘버
public class boj_4673 {
    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10000];

        for (int i = 0; i < 10000; i++) {
            int dn = d(i + 1);
            if (dn <= 10000) arr[dn - 1] = 1;
        }

        for (int i = 0; i < 10000; i++) {
            if (arr[i] == 0) {
                sb.append(i + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
