package gold.g5;

import java.io.*;
import java.util.*;

// 암호 만들기
public class boj_1759 {
    static int L, C;
    static char[] arr;
    static char[] pwd;
    static StringBuilder sb = new StringBuilder();

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static void dfs(int start, int depth, int vowel, int consonant) {
        if (depth == L) {
            if (vowel >= 1 && consonant >= 2) {
                sb.append(pwd).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            char ch = arr[i];
            pwd[depth] = ch;

            if (isVowel(ch)) dfs(i + 1, depth + 1, vowel + 1, consonant);
            else dfs(i + 1, depth + 1, vowel, consonant + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pwd = new char[L];
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0, 0, 0);

        System.out.println(sb);
    }
}
