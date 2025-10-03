package silver;

import java.io.*;
import java.util.*;

// DNA 비밀번호
public class boj_12891 {
    static int[] arr = new int[4];
    static int[] cur = new int[4];

    static int getIdx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (cur[i] < arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < P; i++) {
            cur[getIdx(DNA.charAt(i))]++;
        }
        if (check()) ans++;

        for (int i = P; i < S; i++) {
            cur[getIdx(DNA.charAt(i - P))]--;
            cur[getIdx(DNA.charAt(i))]++;
            if (check()) ans++;
        }

        System.out.println(ans);
    }
}
