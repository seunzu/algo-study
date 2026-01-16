package platinum.p5;

import java.io.*;
import java.util.*;

// 찾기
public class boj_1786 {
    static String text, pattern;

    static int[] getPi() {
        int[] pi = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static List<Integer> kmp() {
        int[] pi = getPi();
        List<Integer> result = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {

                    result.add(i - pattern.length() + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        text = br.readLine();
        pattern = br.readLine();

        List<Integer> result = kmp();
        sb.append(result.size()).append('\n');
        for (int r : result) {
            sb.append(r).append(' ');
        }
        System.out.println(sb);
    }
}
