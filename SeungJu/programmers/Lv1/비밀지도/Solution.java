package 비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int map = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(map);

            binary = String.format("%" + n + "s", binary);

            binary = binary.replace('1', '#')
                    .replace('0', ' ');

            answer[i] = binary;
        }

        return answer;
    }
}