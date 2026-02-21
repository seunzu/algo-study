package recursion;

import java.io.*;
import java.util.*;

// Z
public class boj_1074 {
    static int r, c;
    static int result = 0;

    public static void find(int x, int y, int size) {
        if (size == 1) return;

        int half = size / 2;

        if (r < x + half && c < y + half) {
            find(x, y, half);
        } else if (r < x + half && c >= y + half) {
            result += half * half;
            find(x, y + half, half);
        } else if (r >= x + half && c < y + half) {
            result += half * half * 2;
            find(x + half, y, half);
        } else {
            result += half * half * 3;
            find(x + half, y + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = 1 << N;
        find(0, 0, size);
        System.out.println(result);
    }
}