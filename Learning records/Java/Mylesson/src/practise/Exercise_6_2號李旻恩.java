package practise;

/*
 * ◆ 請寫出一個程式讀入一個整數a,畫出以下形狀。
 * ➢ 基本題:輸入3,呈現如下形狀。
 * |*       => 1=1
 * |* *     => 2=2
 * |* * *   => 3=3
 * 
 * ➢ 進階題:輸入3,呈現如下形狀。
 * |*
 * |* *
 * |* * *
 * |* *
 * |*
*/

import java.util.Scanner;

public class Exercise_6_2號李旻恩 {
    public static void main(String[] args) {
        // 宣告
        Scanner scanner = new Scanner(System.in);
        int a;
        // 輸入
        System.out.print("請輸入一個正整數 a ：");
        // a = getNextInt(scanner);
        // while (a <= 0) {
        // System.out.println("請輸入 >0 的整數：");
        // a = getNextInt(scanner);
        // }
        a = 3; // 測試

        // 【圖形題：迴圈外圈，是列個數，內圈行個數】
        System.out.println("------------------------------------------------");
        // 基本題: (1/4菱形圖形)
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
        // 進階題: (1/2右菱形圖形) 方法一
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = a - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------");
        // 進階題: (1/2右菱形圖形) 方法二
        for (int i = -(a - 1); i <= (a - 1); i++) {
            for (int j = 0; j < a - Math.abs(i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------");
        // 進階題: (1/2上菱形圖形)
        for (int i = 0; i <= a - 1; i++) {
            // 空格
            for (int j = 0; j < a - i - 1; j++) {
                System.out.print(" ");
            }
            // *
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            // for (int j = 0; j < a - Math.abs(i); j++) {
            // }
            System.out.println();
        }

        System.out.println("------------------------------------------------");
        // 進階題: (菱形圖形)
        for (int i = -(a - 1); i <= (a - 1); i++) {
            // 空格
            for (int j = 0; j < Math.abs(i); j++) {
                System.out.print(" ");
            }
            // *
            for (int j = 0; j < a - Math.abs(i); j++) {
                System.out.print("* ");
            }
            // for (int j = 0; j < a - Math.abs(i); j++) {
            // }
            System.out.println();
        }

        scanner.close();
    }

    // 檢查輸入型態函式
    public static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("請輸入正確型態的數字(Int)：");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
