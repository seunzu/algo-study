package 캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) time += 1;
            else {
                time += 5;
                if (cacheSize > 0 && cache.size() >= cacheSize) {
                    cache.removeFirst();
                }
            }

            if (cacheSize > 0) cache.add(city);
        }

        return time;
    }
}