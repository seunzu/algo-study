import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (i != 0 && i % 5 == 0) {
                result.add(names[i]);
            } else if (i == 0) {
                result.add(names[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}