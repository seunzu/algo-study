package platinum.p3;

import java.io.*;
import java.util.*;

// Suffix Array
public class boj_9248 {
    static String s;
    static int n;
    static Integer[] sa;
    static int[] lcp;

    static void buildSuffixArray() {
        sa = new Integer[n];
        int[] rank = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }

        for (int k = 1; k < n; k <<= 1) {
            final int kk = k;

            Arrays.sort(sa, (a, b) -> {
                if (rank[a] != rank[b]) return rank[a] - rank[b];
                int ra = a + kk < n ? rank[a + kk] : -1;
                int rb = b + kk < n ? rank[b + kk] : -1;
                return ra - rb;
            });

            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                int prev = sa[i - 1];
                int cur = sa[i];
                boolean diff = rank[prev] != rank[cur];
                int prev2 = prev + kk < n ? rank[prev + kk] : -1;
                int cur2 = cur + kk < n ? rank[cur + kk] : -1;
                if (prev2 != cur2) diff = true;
                tmp[cur] = tmp[prev] + (diff ? 1 : 0);
            }

            System.arraycopy(tmp, 0, rank, 0, n);
            if (rank[sa[n - 1]] == n - 1) break;
        }
    }

    static void buildLcp() {
        lcp = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r > 0) {
                int j = sa[r - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                    h++;
                }
                lcp[r] = h;
                if (h > 0) h--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
        n = s.length();

        buildSuffixArray();
        buildLcp();

        for (int i = 0; i < n; i++) {
            sb.append(sa[i] + 1);
            if (i + 1 < n) sb.append(" ");
        }

        sb.append("\n");
        sb.append("x ");
        for (int i = 1; i < n; i++) {
            sb.append(lcp[i]);
            if (i + 1 < n) sb.append(" ");
        }

        System.out.println(sb);
    }
}