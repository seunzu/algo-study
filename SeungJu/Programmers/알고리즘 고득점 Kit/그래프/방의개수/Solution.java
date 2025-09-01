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

class Solution {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        int answer = 0;

        Set<Node> visitedNodes = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();

        Node cur = new Node(0, 0);
        visitedNodes.add(cur);

        for (int a : arrows) {
            for (int i = 0; i < 2; i++) {
                Node next = new Node(cur.x + dx[a], cur.y + dy[a]);

                String edge1 = cur.toString() + "->" + next.toString();
                String edge2 = next.toString() + "->" + cur.toString();

                if (visitedNodes.contains(next) && !visitedEdges.contains(edge1)) {
                    answer++;
                }

                visitedNodes.add(next);
                visitedEdges.add(edge1);
                visitedEdges.add(edge2);

                cur = next;
            }
        }

        return answer;
    }
}