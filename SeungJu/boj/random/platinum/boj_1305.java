package platinum;

import java.io.*;

// 광고
public class boj_1305 {
    static int L;
    static String text;

    static int[] getPi() {
        int[] pi = new int[text.length()];
        int j = 0;

        for (int i = 1; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != text.charAt(j)) {
                j = pi[j - 1];
            }
            if (text.charAt(i) == text.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        text = br.readLine();

        int[] pi = getPi();
        System.out.println(L - pi[L - 1]);
    }
}
