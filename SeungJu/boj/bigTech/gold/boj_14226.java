package gold;

import java.io.*;
import java.util.*;

// 이모티콘
class State {
    int screen, clipboard, time;

    public State(int screen, int clipboard, int time) {
        this.screen = screen;
        this.clipboard = clipboard;
        this.time = time;
    }
}

public class boj_14226 {
    static int S;
    static final int MAX = 2001;
    static boolean[][] visited = new boolean[MAX][MAX];

    static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(1, 0, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.screen == S) {
                System.out.println(cur.time);
                return;
            }

            if (cur.screen < MAX && !visited[cur.screen][cur.screen]) {
                visited[cur.screen][cur.screen] = true;
                q.offer(new State(cur.screen, cur.screen, cur.time + 1));
            }

            if (cur.clipboard > 0 && cur.screen + cur.clipboard < MAX && !visited[cur.screen + cur.clipboard][cur.clipboard]) {
                visited[cur.screen + cur.clipboard][cur.clipboard] = true;
                q.offer(new State(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
            }

            if (cur.screen > 0 && !visited[cur.screen - 1][cur.clipboard]) {
                visited[cur.screen - 1][cur.clipboard] = true;
                q.offer(new State(cur.screen - 1, cur.clipboard, cur.time + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        bfs();
    }
}
