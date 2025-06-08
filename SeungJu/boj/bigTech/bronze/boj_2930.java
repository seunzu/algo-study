package bronze;

import java.io.*;
import java.util.*;

// 가위 바위 보
public class boj_2930 {
    public static int getScore(char a, char b) {
        if (a == b) return 1;
        if ((a == 'S' && b == 'P') || (a == 'P' && b == 'R') || (a == 'R' && b == 'S')) return 2;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        List<char[]> target = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            target.add(br.readLine().toCharArray());
        }

        int curScore = 0;
        for (int i = 0; i < R; i++) {
            for (char[] c : target) {
                curScore += getScore(arr[i], c[i]);
            }
        }

        int max = 0;
        for (int i = 0; i < R; i++) {
            int r = 0, s = 0, p = 0;

            for (char[] c : target) {
                switch (c[i]) {
                    case 'S': s++; break;
                    case 'P': p++; break;
                    case 'R': r++; break;
                }
            }

            max += Math.max(2 * s + r, Math.max(2 * p + s, 2 * r + p));
        }

        System.out.println(curScore + "\n" + max);
    }
}
