package 최솟값만들기;

import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int size = A.length;
        for(int i = 0; i < size; i++){
            sum += A[i] * B[size - i - 1];
        }

        return sum;
    }
}