package gold.g1;

import java.io.*;
import java.util.*;

// 낚시왕
public class boj_17143 {
    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    static List<Shark> sharks;

    static int catchShark(int col) {
        Shark target = null;
        int minRow = R;

        for (Shark s : sharks) {
            if (s.c == col && s.r < minRow) {
                minRow = s.r;
                target = s;
            }
        }

        if (target != null) {
            sharks.remove(target);
            return target.z;
        }

        return 0;
    }

    static List<Shark> moveSharks() {
        Map<Integer, Shark> HM = new HashMap<>();

        for (Shark s : sharks) {
            int move = s.s;

            if (s.d == 1 || s.d == 2) move %= (R - 1) * 2;
            else move %= (C - 1) * 2;

            for (int i = 0; i < move; i++) {
                int nr = s.r + dr[s.d];
                int nc = s.c + dc[s.d];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    if (s.d == 1) s.d = 2;
                    else if (s.d == 2) s.d = 1;
                    else if (s.d == 3) s.d = 4;
                    else if (s.d == 4) s.d = 3;

                    nr = s.r + dr[s.d];
                    nc = s.c + dc[s.d];
                }

                s.r = nr;
                s.c = nc;
            }

            int key = s.r * C + s.c;
            if (!HM.containsKey(key) || HM.get(key).z < s.z) {
                HM.put(key, s);
            }
        }

        return new ArrayList<>(HM.values());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new ArrayList<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, s, d, z));
        }

        int ans = 0;
        for (int col = 0; col < C; col++) {
            ans += catchShark(col);
            sharks = moveSharks();
        }

        System.out.println(ans);
    }
}
