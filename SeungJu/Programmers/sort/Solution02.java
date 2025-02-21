import java.util.*;

// 가장 큰 수
public class Solution02 {
    public String solution(int[] numbers) {
        String str[] = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (str[0].equals("0")) return "0";

        return String.join("", str);
    }

    public static void main(String[] args) {
        Solution02 T = new Solution02();
        System.out.println(T.solution(new int[]{6, 10, 2}));
    }
}
