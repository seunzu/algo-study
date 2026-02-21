package silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 랭킹전 대기열
class Player implements Comparable<Player> {
    int level;
    String name;
    boolean check;

    Player(int level, String name) {
        this.level = level;
        this.name = name;
        this.check = false;
    }

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}

public class boj_20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Player[] players = new Player[p];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            players[i] = new Player(l, n);
        }

        for (int i = 0; i < p; i++) {
            if (players[i].check) continue;

            List<Player> room = new ArrayList<>();
            int baseLevel = players[i].level;


            for (int j = 0; j < p; j++) {
                if (room.size() == m) break;

                if (!players[j].check) {
                    int currLevel = players[j].level;
                    if (currLevel >= baseLevel - 10 && currLevel <= baseLevel + 10) {
                        room.add(players[j]);
                        players[j].check = true;
                    }
                }
            }

            Collections.sort(room);
            if (room.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            for (Player player : room) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb);
    }
}