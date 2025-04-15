package 이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') answer[1]++;
                else n++;
            }
            s = Integer.toBinaryString(n);
            answer[0]++;
        }

        return answer;
    }
}