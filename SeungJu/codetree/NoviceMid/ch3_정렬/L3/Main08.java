package ch3_정렬.L3;

import java.util.*;

// 정렬된 수 위치 알아내기
class Element implements Comparable<Element> {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element o) {
        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Element[] arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(sc.nextInt(), i);
        }

        Arrays.sort(arr);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[arr[i].index] = i + 1;
        }

        for (int i : result) System.out.print(i + " ");
    }
}