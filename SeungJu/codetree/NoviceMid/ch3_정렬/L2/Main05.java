package ch3_정렬.L2;

import java.util.*;

// 상품 코드
class Product {
    String name;
    int code;

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public void productInfo() {
        System.out.printf("product %d is %s\n", code, name);
    }
}
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        int code = sc.nextInt();

        Product product1 = new Product("codetree", 50);
        Product product2 = new Product(name, code);

        product1.productInfo();
        product2.productInfo();
    }
}