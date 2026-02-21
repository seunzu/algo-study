package graph;

import java.io.*;
import java.util.*;

// 거짓말
public class boj_1043 {
    static int N, M;
    static int[] unf;
    static List<Integer> truthPeople;
    static List<List<Integer>> parties;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fb] = fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        truthPeople = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            for (int j = 0; j < cnt - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
        }

        if (truthPeople.isEmpty()) {
            System.out.println(M);
            return;
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int x : truthPeople) {
            truthRoots.add(find(x));
        }

        int ans = 0;
        for (List<Integer> party : parties) {
            boolean flag = true;

            for (int p : party) {
                if (truthRoots.contains(find(p))) {
                    flag = false;
                    break;
                }
            }

            if (flag) ans++;
        }

        System.out.println(ans);
    }
}
