package tree;

import java.io.*;
import java.util.*;

// 트리
public class boj_4803 {
    static int[] unf;
    static boolean[] isTree;

    static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fb] = fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            unf = new int[n + 1];
            isTree = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                unf[i] = i;
                isTree[i] = true;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int fa = Find(a);
                int fb = Find(b);

                if (fa == fb) isTree[fa] = false;
                else {
                    boolean treeStatus = isTree[fa] && isTree[fb];
                    Union(fa, fb);
                    int root = Find(fa);
                    isTree[root] = treeStatus;
                }
            }

            Set<Integer> tree = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int root = Find(i);
                if (isTree[root]) tree.add(root);
            }

            sb.append("Case ").append(cnt++).append(": ");
            int treeCnt = tree.size();
            if (treeCnt == 0) sb.append("No trees.\n");
            else if (treeCnt == 1) sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(treeCnt).append(" trees.\n");
        }

        System.out.println(sb);
    }
}
