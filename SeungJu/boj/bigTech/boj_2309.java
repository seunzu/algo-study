import java.io.*;
import java.util.*;

// 일곱 난쟁이
public class boj_2309 {
    static int[] arr = new int[9];
    static int[] selected = new int[7];
    static boolean found = false;

    public static void combine(int start, int depth) {
        if (found) return;

        if (depth == 7) {
            int sum = 0;
            for (int i : selected) sum += i;

            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(selected[i]);
                }
                found = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected[depth] = arr[i];
            combine(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        combine(0, 0);
    }
}
