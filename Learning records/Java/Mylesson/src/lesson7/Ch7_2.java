package lesson7;

import java.util.Arrays;
import java.util.Scanner;

public class Ch7_2 {
    public static void main(String[] args) {
        String name = "Mario";
        String email = "Mario@gmail.com";
        String password = "123456";
        double age = 24.5;
        System.out.println(email.length());
        System.out.println(Arrays.toString(email.toCharArray()));
        System.out.println(email.charAt(0));
        for (char c : email.toCharArray()) {
            System.out.print(c + " , ");
        }
        System.out.println();
        System.out.println("------------------------------");
        System.out.printf("%s \t email: %s \t password: %s \t age: %5.1f\n",
                name, email, password, age);
        System.out.printf("%s \t email: %s \t password: %s \t age: %5.1f\n",
                "Kevin", "Kevin@gmail.com", password, 30.); // 加點才為浮點數
        System.out.println("------------------------------");

        // String.format
        String info1 = String.format("%s \t email: %s \t password: %s \t age: %5.1f\n",
                name, email, password, age);
        String info2 = String.format("%s \t email: %s \t password: %s \t age: %5.1f\n",
                "Kevin", "Kevin@gmail.com", password, 30.); // 加點才為浮點數

        System.out.println(info1 + info2);
        System.out.println("------------------------------");

        // 型態轉換 ---> 要轉換的型態.valueOf()
        // String.valueOf() Double.valueOf() Integer.valueOf()
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入分數：");
        // 99 , 99.5
        String score = scanner.next();
        System.out.println(score);
        System.out.println(score + 5);

        // Double.valueOf()
        System.out.println(Double.valueOf(score) + 5); // String --> Double

        // Integer.valueOf()
        System.out.println(Integer.valueOf(score) + 5); // String --> Double
        int x = 10;
        float y = 20;
        System.out.println("數值型態 " + x + y); // 字串被轉成數值
        System.out.println("數值型態 " + (x + y));

        // String.valueOf()
        System.out.println("字串型態 " + String.valueOf(x + y));
        scanner.close();

    }
}
