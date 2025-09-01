package 그래프.방의개수;

import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

class Solution2 {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        int answer = 0;

        Map<Node, ArrayList<Node>> graph = new HashMap<>();

        Node cur = new Node(0, 0);
        graph.putIfAbsent(cur, new ArrayList<>());

        for (int a : arrows) {
            for (int i = 0; i < 2; i++) {
                Node next = new Node(cur.x + dx[a], cur.y + dy[a]);

                graph.putIfAbsent(cur, new ArrayList<>());
                graph.putIfAbsent(next, new ArrayList<>());

                if (graph.get(cur).contains(next) == false) {
                    if (graph.containsKey(next) && !graph.get(next).isEmpty()) {
                        answer++;
                    }
                    graph.get(cur).add(next);
                    graph.get(next).add(cur);
                }

                cur = next;
            }
        }

        return answer;
    }
}