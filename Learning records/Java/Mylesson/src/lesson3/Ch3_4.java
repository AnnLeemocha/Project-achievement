package lesson3;

import java.util.Scanner;

public class Ch3_4 {
    public static void main(String[] args) {
        int x = 10;
        int y = 50;

        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println(x >= y);
        System.out.println(x > y);
        System.out.println(x <= y);
        System.out.println(x < y);

        // 實務演練
        if (x != y) { // True
            System.out.printf("x=%d\ty=%d\n", x, y);
        }

        Scanner input = new Scanner(System.in);
        // 輸入遇到空格會當作下一個輸入
        System.out.println("請輸入兩個數字(空白做區間)");

        int a = input.nextInt();
        int b = input.nextInt();

        boolean c = a > b;

        if (c) { // True
            System.out.printf("a=%d\tb=%d\t->\t數字 a 比較大", a, b);
        } else { // False
            System.out.printf("a=%d\tb=%d\t->\t數字 a 比較小", a, b);
        }

        input.close();
    }
}
