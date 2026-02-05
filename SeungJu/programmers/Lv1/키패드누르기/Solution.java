package 키패드누르기;

class Solution {
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist(Pos p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    static Pos getPos(int n) {
        if (n == 0) return new Pos(3, 1);
        return new Pos((n - 1) / 3, (n - 1) % 3);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Pos lt = new Pos(3, 0); // *
        Pos rt = new Pos(3, 2); // #

        for (int n : numbers) {
            Pos target = getPos(n);

            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                lt = target;
            } else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                rt = target;
            } else {
                int lDist = lt.dist(target);
                int rDist = rt.dist(target);

                if (lDist < rDist) {
                    sb.append("L");
                    lt = target;
                } else if (lDist > rDist) {
                    sb.append("R");
                    rt = target;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        lt = target;
                    } else {
                        sb.append("R");
                        rt = target;
                    }
                }
            }
        }

        return sb.toString();
    }
}