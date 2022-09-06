package lesson5;

// import java.util.Scanner;

import lesson6.Ch6_1;

public class Test {
    public static void main(String[] args) {
        // import java.util.Scanner;
        // Scanner input = new Scanner(System.in);
        // java.util.Scanner input = new java.util.Scanner(System.in);

        // 只要是全公開(public)都可以呼叫到，記得 import lesson6.Ch6_1
        // import lesson6.Ch6_1;
        Ch6_1.sum(10, 20);
        // lesson6.Ch6_1.sum(10, 20);
        Ch6_1.main(args);

        // 若 lesson6.Ch6_1 中的 sum 不加public(代表不公開)，
        // 只能在該 package 使用 (lesson6) 該函式
        // Ch6_1.sum2(10, 20);

        // 全私有 (只在Ch6_1可以使用)
        // Ch6_1.sum3(10, 20);

        // Input.close();
    }
}
