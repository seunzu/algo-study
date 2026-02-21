package dataStructures.comparator;

import java.io.*;
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) return b.score - a.score;
        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String name = s[0];
            int score = Integer.parseInt(s[1]);
            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            sb.append(p.name).append(" ").append(p.score).append("\n");
        }

        System.out.println(sb.toString());
    }
}
