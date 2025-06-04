import java.io.*;
import java.util.*;

// 전구와 스위치
public class boj_2138 {
    static int N;

    public static void swap(int[] arr, int index) {
        if (index - 1 >= 0) arr[index - 1] ^= 1;
        arr[index] ^= 1;
        if (index + 1 < arr.length) arr[index + 1] ^= 1;
    }

    public static boolean check(int[] a, int[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static int simulate(int[] origin, int[] target, boolean pressFirst) {
        int[] bulb = Arrays.copyOf(origin, N);
        int cnt = 0;

        if (pressFirst) {
            swap(bulb, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (bulb[i - 1] != target[i - 1]) {
                swap(bulb, i);
                cnt++;
            }
        }

        if (check(bulb, target)) return cnt;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] origin = new int[N];
        for (int i = 0; i < N; i++) origin[i] = s1.charAt(i) - '0';

        int[] target = new int[N];
        for (int i = 0; i < N; i++) target[i] = s2.charAt(i) - '0';

        int result1 = simulate(origin, target, false);
        int result2 = simulate(origin, target, true);

        int answer = -1;
        if (result1 != -1 && result2 != -1) answer = Math.min(result1, result2);
        else if (result1 != -1) answer = result1;
        else if (result2 != -1) answer = result2;

        System.out.println(answer);
    }
}
