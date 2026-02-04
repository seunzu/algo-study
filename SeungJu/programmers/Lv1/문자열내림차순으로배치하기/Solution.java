package 문자열내림차순으로배치하기;

import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return new StringBuilder(new String(arr))
                .reverse()
                .toString();
    }
}
