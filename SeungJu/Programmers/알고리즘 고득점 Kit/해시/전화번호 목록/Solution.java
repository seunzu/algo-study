import java.util.*;

// 전화번호 목록
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        int index = 0;
        for (String number : phone_book) {
            map.put(number, index++);
        }

        for (String num : phone_book) {
            for (int j = 1; j < num.length(); j++) {
                if (map.containsKey(num.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}