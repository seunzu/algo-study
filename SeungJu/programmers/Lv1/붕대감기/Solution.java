package 붕대감기;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 1;
        int cnt = 0;
        int attackIdx = 0;

        int endTime = attacks[attacks.length - 1][0];
        while (time <= endTime) {

            if (attackIdx < attacks.length && time == attacks[attackIdx][0]) {
                health -= attacks[attackIdx][1];
                cnt = 0;
                attackIdx++;

                if (health <= 0) return -1;
            } else {
                cnt++;
                health += bandage[1];

                if (cnt == bandage[0]) {
                    health += bandage[2];
                    cnt = 0;
                }

                if (health > maxHealth) health = maxHealth;
            }

            time++;
        }

        return health;
    }
}